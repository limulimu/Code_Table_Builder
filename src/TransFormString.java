
public class TransFormString {
	
	public String Transform(String into) {
		
		into=into.replace('(', ' ');
		into=into.replace('\'', ' ');
		into=into.replace(']', ' ');
		String[] s=into.trim().split("-");
		return (s[0]+",");	
	}

}
