package lab7.example.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GSONSample2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Gson gson = new Gson();
		list.add(new Student("gkfla",20));
		list.add(new Student("shave",20));
		list.add(new Student("kentaro",20));
		String jsonstr1 = gson.toJson(list);
		System.out.println(jsonstr1);
		
		try {
			FileWriter fw = new FileWriter("data2.txt");
			fw.write(jsonstr1);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String jsonstr2 = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("data2.txt"));
			jsonstr2 = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일을 가져왔습니다:)");
		Student[] arr = gson.fromJson(jsonstr2, Student[].class);
		List<Student> list1 = Arrays.asList(arr);
		System.out.println("LIST1 : "+list1);
		
		List<Student> list2 = gson.fromJson(jsonstr2, new TypeToken<List<Student>>(){}.getType());
		System.out.println("LIST2 : "+list2);
		
	}
}
