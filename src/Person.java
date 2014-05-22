
public class Person {
private final String FirstName;
private final String SecondName;
private final int Age;
private final String Profession;
 
public static class Builder
{
	private final String FirstName;
	private final int Age;
	private String SecondName = null;
	private String Profession = null;
	
	public Builder(String FirstName, int Age){
		this.FirstName = FirstName;
		this.Age = Age;
	}
	
	public Builder SecondName(String val){
		SecondName = val;
		return this;
	}
		public Builder Profession(String val){
			Profession = val;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
public Person(Builder builder){
	FirstName = builder.FirstName;
	SecondName = builder.SecondName;
	Age = builder.Age;
	Profession = builder.FirstName;
}
public String getFirstName() {
	return FirstName;
}
public String getSecondName() {
	return SecondName;
}
public int getAge() {
	return Age;
}
public String getProfession() {
	return Profession;
}
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Age;
	result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
	result = prime * result
			+ ((Profession == null) ? 0 : Profession.hashCode());
	result = prime * result
			+ ((SecondName == null) ? 0 : SecondName.hashCode());
	return result;
}
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (Age != other.Age)
		return false;
	if (FirstName == null) {
		if (other.FirstName != null)
			return false;
	} else if (!FirstName.equals(other.FirstName))
		return false;
	if (Profession == null) {
		if (other.Profession != null)
			return false;
	} else if (!Profession.equals(other.Profession))
		return false;
	if (SecondName == null) {
		if (other.SecondName != null)
			return false;
	} else if (!SecondName.equals(other.SecondName))
		return false;
	return true;
}
public String toString() {
	return "Person [FirstName=" + FirstName + ", SecondName=" + SecondName
			+ ", Age=" + Age + ", Profession=" + Profession + "]";
}

}

