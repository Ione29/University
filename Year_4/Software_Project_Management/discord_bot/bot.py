import requests
from rapidfuzz import fuzz, process
import discord
from discord.ext import commands
from discord import app_commands
from discord.ui import View, Select

#STEAM
def get_steam_games():
    url = "https://api.steampowered.com/ISteamApps/GetAppList/v1/"
    response = requests.get(url)
    skip_keywords = ['dlc', 'demo', 'trailer', 'test', 'pack', 'soundtrack', 'mod']
    return [game for game in response.json()["applist"]["apps"]["app"]
            if game["name"]
            and len(game["name"]) > 4
            and all(k not in game["name"].lower() for k in skip_keywords)]

def search_game(user_input, games_list, limit=5):
    game_names = [game["name"] for game in games_list if game["name"]]
    matches = process.extract(user_input, game_names, limit=limit, scorer=fuzz.token_sort_ratio)
    return matches

def get_appid_by_name(name, games_list):
    for game in games_list:
        if game["name"].lower() == name.lower():
            return game["appid"]
    return None

def get_steam_game_info(app_id):
    details_url = f"https://store.steampowered.com/api/appdetails?appids={app_id}&cc=us&l=en"
    details_response = requests.get(details_url).json()

    if not details_response[str(app_id)]['success']:
        return None

    game_data = details_response[str(app_id)]['data']
    name = game_data.get('name', 'N/A')
    description = game_data.get('short_description', 'N/A')
    price_info = game_data.get('price_overview', {})
    price = price_info.get('final_formatted', 'Free' if game_data.get('is_free') else 'N/A')

    reviews_url = f"https://store.steampowered.com/appreviews/{app_id}?json=1"
    reviews_response = requests.get(reviews_url).json()
    rating = reviews_response.get('query_summary', {}).get('review_score_desc', 'No rating')

    return {
        "name": name,
        "description": description,
        "price": price,
        "rating": rating,
        "appid": app_id
    }

def get_name_by_app_id(id, games_list):
    details_url = f"https://store.steampowered.com/api/appdetails?appids={id}&cc=us&l=en"
    details_response = requests.get(details_url).json()
    if not details_response[str(id)]['success']:
        return "Invalid App ID or game not found."
    return details_response[str(id)]['data'].get('name', 'N/A')

def get_top_steam_games(games_list, limit=10):
    url = "https://api.steampowered.com/ISteamChartsService/GetMostPlayedGames/v1/"
    response = requests.get(url).json()

    top = response.get("response", {}).get("ranks", [])[:limit]
    return [
        {
            "rank": game["rank"],
            "name": get_name_by_app_id(game["appid"], games_list),
            "players": game["peak_in_game"],
            "appid": game["appid"]
        }
        for game in top
    ]

#DISCORD
intents = discord.Intents.default()
bot = commands.Bot(command_prefix="!", intents=intents)
games_cache = get_steam_games()

class SteamSelect(Select):
    def __init__(self, matches, games_list):
        self.games_list = games_list
        options = []
        seen = set()
        for i, (name, score, _) in enumerate(matches):
            if name.lower() in seen:
                continue
            seen.add(name.lower())
            options.append(
                discord.SelectOption(
                    label=name[:100],
                    description=f"Score: {int(score)}",
                    value=f"{name}__{i}"
                )
            )

        super().__init__(placeholder="Choose a game...", options=options, min_values=1, max_values=1)

    async def callback(self, interaction: discord.Interaction):
        selected_name = self.values[0].split("__")[0]
        appid = get_appid_by_name(selected_name, self.games_list)
        info = get_steam_game_info(appid)

        if info:
            embed = discord.Embed(
                title=info["name"],
                description=info["description"],
                color=discord.Color.green()
            )
            embed.add_field(name="Price", value=info["price"], inline=True)
            embed.add_field(name="Rating", value=info["rating"], inline=True)
            embed.add_field(name="Steam Link", value=f"https://store.steampowered.com/app/{info['appid']}", inline=False)
            await interaction.response.edit_message(content=None, embed=embed, view=None)
        else:
            await interaction.response.send_message("Failed to get game info.", ephemeral=True)

@bot.event
async def on_ready():
    await bot.tree.sync()
    print(f"✅ Logged in as {bot.user}")

@bot.tree.command(name="search", description="Search for a Steam game")
@app_commands.describe(game_name="The name of the game to search for")
async def search(interaction: discord.Interaction, game_name: str):
    matches = search_game(game_name, games_cache, limit=5)

    if not matches:
        await interaction.response.send_message("No matches found.")
        return

    view = View()
    view.add_item(SteamSelect(matches, games_cache))
    await interaction.response.send_message(f"🔍 Select the game that matches **{game_name}**:", view=view)

@bot.tree.command(name="topgames", description="Shows the most-played games on Steam right now")
@app_commands.describe(limit="Number of top games to show (1–25)")
async def topgames(interaction: discord.Interaction, limit: int = 10):
    if limit < 1 or limit > 25:
        await interaction.response.send_message("Limit must be between 1 and 25.", ephemeral=True)
        return

    await interaction.response.defer()

    top_games = get_top_steam_games(games_cache, limit=limit)

    if not top_games:
        await interaction.followup.send("Could not fetch top games.")
        return

    description = ""
    for game in top_games:
        description += f"**{game['rank']}. {game['name']}** — {game['players']:,} peak players in game today\n"
        description += f"[Steam Link](https://store.steampowered.com/app/{game['appid']})\n\n"

    embed = discord.Embed(
        title=f"🔥 Top {limit} Most-Played Games on Steam",
        description=description,
        color=discord.Color.orange()
    )

    await interaction.followup.send(embed=embed)

bot.run("key_here")

