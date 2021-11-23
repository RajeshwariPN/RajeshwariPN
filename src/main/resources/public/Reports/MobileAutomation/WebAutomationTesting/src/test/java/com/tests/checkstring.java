package com.tests;

public class checkstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//String path="D:\\security\\Shoppingcart";
		

		
		//String newpath=path.replaceAll("\\","/");
		
		//System.out.println(newpath);
		
		String projectName="balu";
		String projectPath="bhaskar";
		String reportPath="path";
		
		System.out.println("\"dependency-check --noupdate --project" +projectName+ " --scan"+ projectPath+ " --format HTML --out " +reportPath+"");
				}

}
