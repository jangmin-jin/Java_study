package ex01;

public class CapitalizeName {
	public String capitalizeName( String strName ) {
		String[] names = strName.split(" ");
		String result = "";
		
		for(String name : names) {
			result += name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
		}
		return result;
	}
}