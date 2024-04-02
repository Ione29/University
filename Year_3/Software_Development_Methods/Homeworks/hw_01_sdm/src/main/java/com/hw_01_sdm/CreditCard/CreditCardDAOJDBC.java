package com.hw_01_sdm.CreditCard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.hw_01_sdm.CoreDaoJDBC;

public class CreditCardDAOJDBC extends CoreDaoJDBC implements CreditCardDAO{

    @Override
    public Set<CreditCard> findAll() {
        Set<CreditCard> creditCards =new HashSet<>();
        String findAllCreditCardsSQL = "SELECT * FROM creditCard";
        try (
                PreparedStatement findAllCreditCards = connection.prepareStatement(findAllCreditCardsSQL);
        ) {
            ResultSet results = findAllCreditCards.executeQuery();
            while (results.next()){
                CreditCard foundCreditCard =new CreditCard(results.getInt("id"), results.getString("IBAN"), results.getDouble("amount"), results.getInt("owner_id"));
                creditCards.add(foundCreditCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditCards;
    }

    @Override
    public Set<CreditCard> findByIBAN(String IBAN) {
        Set<CreditCard> creditCards = new HashSet<>();

        String findByIBANSQL = "SELECT * FROM creditCard WHERE IBAN = ?";
        try(
            PreparedStatement findByIBAN = connection.prepareStatement(findByIBANSQL);
        ) {
            findByIBAN.setString(1, IBAN);
            ResultSet results = findByIBAN.executeQuery();
            
            while(results.next()){
                CreditCard foundCreditCard = new CreditCard(results.getInt("id"), results.getString("IBAN"), results.getDouble("amount"), results.getInt("owner_id"));
                creditCards.add(foundCreditCard);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return creditCards;
    }

    public Set<CreditCard> findByOwner(int owner_id){
        Set<CreditCard> creditCards = new HashSet<>();

        String findbyOwnerSQL = "SELECT * FROM creditCard WHERE owner_id = ?";
        try(
            PreparedStatement findByOwner = connection.prepareStatement(findbyOwnerSQL);
        ){
            findByOwner.setInt(1, owner_id);
            ResultSet results = findByOwner.executeQuery();

            while(results.next()){
                CreditCard foundCreditCard = new CreditCard(results.getInt("id"), results.getString("IBAN"), results.getDouble("amount"), results.getInt("owner_id"));
                creditCards.add(foundCreditCard);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return creditCards;
    }

    @Override
    public CreditCard insert(CreditCard creditCard) {
        String insertCreditCardSQL = "INSERT into creditCard (IBAN, amount, owner_id) values (?,?,?)";
        String checkCreditCardSQL = "SELECT * FROM creditCard WHERE IBAN = ?";
        try (
            PreparedStatement checkCreditCard = connection.prepareStatement(checkCreditCardSQL);
            PreparedStatement insertCreditCard = connection.prepareStatement(insertCreditCardSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            //check if the credit card already exists
            checkCreditCard.setString(1, creditCard.getIBAN());
            
            ResultSet results = checkCreditCard.executeQuery();
            if(results.next())
                return creditCard; //exit if the address is in the database

            insertCreditCard.setString(1,creditCard.getIBAN());
            insertCreditCard.setDouble(2,creditCard.getAmount());
            insertCreditCard.setInt(3, creditCard.getOwner_id());
            insertCreditCard.executeQuery();
            var generatedKeys = insertCreditCard.getGeneratedKeys();
            if (generatedKeys.next()) {
                creditCard.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditCard;
    }

    @Override
    public void update(CreditCard creditCard) {
        String updateCreditCardSQL = "UPDATE creditCard SET IBAN = ?, amount = ?, owner_id = ? WHERE id = ?";

        try(
            PreparedStatement updateCreditCard = connection.prepareStatement(updateCreditCardSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            updateCreditCard.setString(1, creditCard.getIBAN());
            updateCreditCard.setDouble(2, creditCard.getAmount());
            updateCreditCard.setInt(3, creditCard.getOwner_id());
            updateCreditCard.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int creditCardId) {
        String deleteCreditCardSQL = "DELETE FROM creditCard WHERE id = ?";
        try(
            PreparedStatement deleteCreditCard = connection.prepareStatement(deleteCreditCardSQL);
        ) {
            deleteCreditCard.setInt(1, creditCardId);
            deleteCreditCard.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
