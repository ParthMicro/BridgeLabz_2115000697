import java.util.*; 
class UserNode { 
    int userId; 
    String name; 
    int age; 
    LinkedList<Integer> friends; 
    UserNode next; 
    public UserNode(int userId, String name, int age) { 
        this.userId = userId; 
        this.name = name; 
        this.age = age; 
        this.friends = new LinkedList<>(); 
        this.next = null; 
    } 
} 
class SocialMedia { 
    private UserNode head; 
    public SocialMedia() { 
        this.head = null; 
    } 
    public void addUser(int userId, String name, int age) { 
        UserNode newUser = new UserNode(userId, name, age); 
        if (head == null) { 
            head = newUser; 
        } else { 
            UserNode temp = head; 
 
            while (temp.next != null) { 
                temp = temp.next; 
            } 
            temp.next = newUser; 
        } 
    } 
    public void addFriendConnection(int userId1, int userId2) { 
        UserNode user1 = findUserById(userId1); 
        UserNode user2 = findUserById(userId2); 
        if (user1 != null && user2 != null && user1 != user2) { 
            if (!user1.friends.contains(userId2)) 
user1.friends.add(userId2); 
            if (!user2.friends.contains(userId1)) 
user2.friends.add(userId1); 
        } 
    } 
    public void removeFriendConnection(int userId1, int userId2) { 
        UserNode user1 = findUserById(userId1); 
        UserNode user2 = findUserById(userId2); 
        if (user1 != null && user2 != null) { 
            user1.friends.remove((Integer) userId2); 
            user2.friends.remove((Integer) userId1); 
        } 
    } 
    public void findMutualFriends(int userId1, int userId2) { 
        UserNode user1 = findUserById(userId1); 
        UserNode user2 = findUserById(userId2); 
        if (user1 != null && user2 != null) { 
            List<Integer> mutualFriends = new ArrayList<>(); 
            for (int friendId : user1.friends) { 
                if (user2.friends.contains(friendId)) { 
                    mutualFriends.add(friendId); 
                } 
            } 
            if (!mutualFriends.isEmpty()) { 
                System.out.println("Mutual Friends: " + mutualFriends); 
            } else { 
                System.out.println("No mutual friends found."); 
            } 
        } 
    } 
 
    public void displayFriends(int userId) { 
        UserNode user = findUserById(userId); 
        if (user != null) { 
            System.out.println(user.name + "'s Friends: " + user.friends); 
        } 
    } 
    public UserNode findUserById(int userId) { 
        UserNode temp = head; 
        while (temp != null) { 
            if (temp.userId == userId) { 
                return temp; 
            } 
            temp = temp.next; 
        } 
        return null; 
    } 
    public UserNode findUserByName(String name) { 
        UserNode temp = head; 
        while (temp != null) { 
            if (temp.name.equalsIgnoreCase(name)) { 
                return temp; 
            } 
            temp = temp.next; 
        } 
        return null; 
    } 
    public void countFriends(int userId) { 
        UserNode user = findUserById(userId); 
        if (user != null) { 
            System.out.println(user.name + " has " + user.friends.size() + 
" friends."); 
        } 
    } 
    public void displayAllUsers() { 
        UserNode temp = head; 
        while (temp != null) { 
            System.out.println("User ID: " + temp.userId + ", Name: " + 
temp.name + ", Age: " + temp.age); 
            temp = temp.next; 
        } 
    } 
 
    public static void main(String[] args) { 
        SocialMedia socialMedia = new SocialMedia(); 
        socialMedia.addUser(1, "Parth", 22); 
        socialMedia.addUser(2, "Shanya", 24); 
        socialMedia.addUser(3, "Abhinav", 21); 
        socialMedia.addUser(4, "Kshitiz", 23); 
        socialMedia.addFriendConnection(1, 2); 
        socialMedia.addFriendConnection(1, 3); 
        socialMedia.addFriendConnection(2, 3); 
        socialMedia.addFriendConnection(3, 4); 
        socialMedia.displayFriends(1); 
        socialMedia.displayFriends(2); 
        socialMedia.displayFriends(3); 
        socialMedia.displayFriends(4); 
        socialMedia.findMutualFriends(1, 2); 
        socialMedia.findMutualFriends(2, 3); 
        socialMedia.findMutualFriends(1, 4); 
        socialMedia.removeFriendConnection(2, 3); 
        socialMedia.displayFriends(2); 
        socialMedia.displayFriends(3); 
        socialMedia.countFriends(1); 
        socialMedia.countFriends(2); 
        socialMedia.countFriends(3); 
        socialMedia.countFriends(4); 
        socialMedia.displayAllUsers(); 
    } 
} 
