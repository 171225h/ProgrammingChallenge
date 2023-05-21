package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Masking {

	// #9227 May 21 2023
	/*
	 * �����ؼ��� Ʋ���� 2�ð� ���� �ذ��ϴ��� ������ ���� :(
	 * ����ŷ�� *sequentially* �ϰ� �����ؾ��ϴµ�
	 * regex�� Ǯ�ٺ��� sequential�ϰ� Ǫ�� ���� ��ħ
	 */
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<String> dictionary = new ArrayList<>();

		String dictionary_word = "";
		String sentence = "";
		StringBuilder result = null;
		char ch1, ch2;


		
		// dictionary
		dictionary_word = br.readLine();
		while(!dictionary_word.equals("##")) {
			dictionary.add(dictionary_word);
			dictionary_word = br.readLine();
		}

		// process
		sentence = dictionary_word.toString();
		while(!sentence.equals("#")) {

			sentence = br.readLine();
			if(sentence.equals("#"))
				break;

			result = new StringBuilder(sentence);
			
			for(int i = 0; i<sentence.length()-3; i++) {
				
				for(int j = 0; j<dictionary.size(); j++) {
					ch1 = dictionary.get(j).charAt(0);
					ch2 = dictionary.get(j).charAt(1);

					if(result.charAt(i)==ch1 && result.charAt(i+3)==ch2) {
						
						result.replace(i+1, i+3, "**");
						break;
					}
				}
			}
			
			bw.write(result.toString());
			bw.newLine();
			
		}

		bw.flush();
	}
}
