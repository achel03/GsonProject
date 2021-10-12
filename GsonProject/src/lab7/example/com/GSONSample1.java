package lab7.example.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class GSONSample1 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Student s1 = new Student("gkfla",22);
		String jsonstr = gson.toJson(s1);
		System.out.println(jsonstr);
		
		try {
			FileWriter wr = new FileWriter("data.txt");
			wr.write(jsonstr);
			wr.close();
			System.out.println("파일이 저장되었습니다:)");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String jsonstr2 = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("data.txt"));
			jsonstr2 = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Student student = gson.fromJson(jsonstr2,Student.class);
		System.out.println(student);
		
	}
}
