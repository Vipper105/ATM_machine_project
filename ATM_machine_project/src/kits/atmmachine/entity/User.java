package kits.atmmachine.entity;

public class User {
	private long userId;
	private String userName;
	private int age;
	private String sex;
	private String phoneNumber;
	private String address;

	public User() {
	}

	public User(long userId, String userName, int age, String sex, String phoneNumber, String address) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public User(String userName, int age, String sex, String phoneNumber, String address) {
		this.userName = userName;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAllAttributeUser(String userName, int age, String sex, String phoneNumber, String address) {
		this.userName = userName;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	
	public String showInfoUser() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", sex=" + sex + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	

}
