# BlockCord Users & Use Cases

## Users
- Normal Users
- Server Admin
- Developer

## Use Cases
- Users: 
    - Log In
    - Create Accounts
    - Send Message
    - Add friend
    - Delete Account
    - Join Server
- Server Admin: 
    - Inspect Logs
    - Kick server member
    - Ban server member
    - create channel, 
    - create channel category
    - Modify server settings
- Developer: 
    - Delete Communities
    - Monitor System Performance

## Use Case Descriptions

### **Use Case: Send Message**
- **Actor(s):** Normal User
- **Description:** A user sends a message to another user or a group within a server.
- **Preconditions:**
  - The user must be logged in.
  - The user must be a member of the server or have a valid friend connection.
- **Main Flow:**
  1. The user selects a chat or server channel.
  2. The user types a message.
  3. The system sends the message to the intended recipient(s).
  4. The message is displayed in the chat interface.
- **Postconditions:**
  - The message is stored securely in the system.
  - The recipient(s) receive the message in real-time.

---

### **Use Case: Add Friend**
- **Actor(s):** Normal User
- **Description:** A user sends a friend request to another user to establish a connection.
- **Preconditions:**
  - The user must be logged in.
  - The recipient must have a valid account.
- **Main Flow:**
  1. The user searches for another user by username or ID.
  2. The user sends a friend request.
  3. The recipient receives a notification of the friend request.
  4. The recipient accepts or declines the request.
- **Postconditions:**
  - If accepted, the users are added to each other's friend lists.
  - If declined, nothing happens.

---

### **Use Case: Join Server**
- **Actor(s):** Normal User
- **Description:** A user joins a server to participate in its activities.
- **Preconditions:**
  - The user must be logged in.
  - The server must exist.
- **Main Flow:**
  1. The user searches for a server or receives an invite link.
  2. The user requests to join the server.
  3. The system verifies the server's permissions (e.g., public or invite-only).
  4. If allowed, the user is added to the server.
- **Postconditions:**
  - The user becomes a member of the server.
  - The user gains access to the server's channels and activities.

---

### **Use Case: Inspect Logs**
- **Actor(s):** Server Admin
- **Description:** A server admin reviews server activity logs for moderation or troubleshooting purposes.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin navigates to the server's log section.
  2. The admin filters for a specific log type (e.g., message history, member actions).
  3. The system displays the requested logs.
- **Postconditions:**
  - The admin gains insights into server activities.
  - No unauthorized access to logs occurs.

---

### **Use Case: Kick Server Member**
- **Actor(s):** Server Admin
- **Description:** A server admin removes a member from the server.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin selects a member from the server's member list.
  2. The admin chooses the "Kick Member" option.
  3. The system removes the member from the server.
- **Postconditions:**
  - The member is removed but can rejoin if invited or allowed.

---

### **Use Case: Ban Server Member**
- **Actor(s):** Server Admin
- **Description:** A server admin permanently bans a member from the server.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin selects a member from the server's member list.
  2. The admin chooses the "Ban Member" option.
  3. The system removes the member and prevents rejoining.
- **Postconditions:**
  - The member is permanently banned from the server.

---

### **Use Case: Create Channel**
- **Actor(s):** Server Admin
- **Description:** A server admin creates a new channel within the server.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin navigates to the server's channel management section.
  2. The admin selects "Create Channel."
  3. The admin provides channel details (e.g., name, type, permissions).
  4. The system creates the channel.
- **Postconditions:**
  - The new channel is added to the server.

---

### **Use Case: Create Channel Category**
- **Actor(s):** Server Admin
- **Description:** A server admin organizes channels into a new category.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin navigates to the server's category management section.
  2. The admin selects "Create Category."
  3. The admin provides category details (e.g., name).
  4. The system creates the category.
- **Postconditions:**
  - The new category is added to the server.
  - Channels can be assigned to the category.

---

### **Use Case: Modify Server Settings**
- **Actor(s):** Server Admin
- **Description:** A server admin updates the server's settings.
- **Preconditions:**
  - The admin must be logged in.
  - The admin must have the necessary permissions.
- **Main Flow:**
  1. The admin navigates to the server settings section.
  2. The admin modifies settings (e.g., permissions, roles, server name).
  3. The admin saves the changes.
  4. The system implements the changes.
- **Postconditions:**
  - The server settings are updated.

---

### **Use Case: Delete Communities**
- **Actor(s):** Developer
- **Description:** A developer removes a community from the platform.
- **Preconditions:**
  - The developer must be logged in.
  - The developer must have the necessary permissions.
- **Main Flow:**
  1. The developer identifies the community to delete.
  2. The developer confirms the deletion.
  3. The system removes the community and its data.
- **Postconditions:**
  - The community is permanently deleted.

---

### **Use Case: Monitor System Performance**
- **Actor(s):** Developer
- **Description:** A developer monitors the platform's performance metrics.
- **Preconditions:**
  - The developer must be logged in.
  - The developer must have the necessary permissions.
- **Main Flow:**
  1. The developer accesses the performance dashboard.
  2. The system displays metrics (e.g., server load, response times).
  3. The developer analyzes the data.
- **Postconditions:**
  - The developer gains insights into system performance.
  - No unauthorized access to performance data occurs.
