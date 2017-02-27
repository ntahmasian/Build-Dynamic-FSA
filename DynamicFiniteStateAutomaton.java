/**
 * CS 311 Formal Languages and Automata
 * Project #2 - Build Dynamic FSA
 * Dr. Daisy Sang
 * Author: Narvik Tahmasian
 *
 * We have two input files, Project2_Input1.txt & Project2_Input2.txt 
 * They hold Java reserved words and a Java program respectively.
 * 
 * DynamicFSA simulates is a program that recognize 
 * Java reserved words and identifiers 
 *
 * How to compile, link, and run this program:
 *   1) Please make sure Project2_Input1.txt and Project2_Input2.txt are in the directory before running the program
 *   2) In CMD
 *   3) javac DynamicFSA.java
 *   4) java DynamicFSA
 */

import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;

public class DynamicFiniteStateAutomaton {
	private static int[] switchh = new int[54];
	private static int[] next = new int[5000];
	private static char[] symbolArr = new char[5000];
	private static ArrayList<String> ReservedWords = new ArrayList<String>();	// arrayList for all the reserved words
	private static ArrayList<String> eachWirdOfFile2 = new ArrayList<String>();	// arrayList for all the identifiers
	private static int symbolPtr = 0; // Pointer to first Available slot in Symbol Array

	public static void main(String[] args) throws Exception {

		Arrays.fill(switchh, -1);
		Arrays.fill(next, -1);

		// read File 1 and extract the reserved words
		FileReader fr = new FileReader("Project2_Input1.txt");
		Scanner scan = new Scanner(fr);
		while (scan.hasNext()) {
			ReservedWords.add(scan.next());
		}

		// read File 2 and extract the identifiers 
		fr = new FileReader("Project2_Input2.txt");
		scan = new Scanner(fr);
		scan.useDelimiter("\n");
		String temp;
		while (scan.hasNextLine()) {
			temp = scan.next();
			if (!temp.equals("")) {
				lineProcessor(temp);
			}
		}
		for (int i = 0; i < ReservedWords.size(); i++) {
			String word = ReservedWords.get(i);
			buildTheSymbolArray(word);

		}
		for (int i = 0; i < eachWirdOfFile2.size(); i++) {
			String word = eachWirdOfFile2.get(i);
			buildTheSymbolArray(word);

		}
		print();
	}

	// start building the symbol array char by char
	private static void buildTheSymbolArray(String word) {

		char wordChar = word.charAt(0);

		if (switchh[(getTheIndexOfCharacter(wordChar))] == -1) {
			// The slot has not been filled yet so it is the
			// very first time being added
			switchh[getTheIndexOfCharacter(wordChar)] = symbolPtr;
			addWordToSymbolArray(word, 1);

		} else {
			// So the slot has a location to refer to
			int follow = switchh[(getTheIndexOfCharacter(wordChar))];
			for (int i = 1; i < word.length(); i++) {
				wordChar = word.charAt(i);
				
				// if the char matches and its not the end of the word then continue 
				if (symbolArr[follow] == wordChar && word.length() != i) {
					// ignore
					follow++;
					
				} else { 
					// now we check for the next called slot
					if (next[follow] == -1) {
						next[follow] = symbolPtr;
						addWordToSymbolArray(word, i);
						break;
					} else {
						follow = next[follow];
						i--;

					}
				}
			}
		}
	}

	// Fill in the available slots and add the word in symbol array
	private static void addWordToSymbolArray(String word, int counter) {
		for (; counter < word.length(); counter++) {
			symbolArr[symbolPtr] = word.charAt(counter);
			symbolPtr++;
		}
		// if the word is a Reserved word, we add '*' at the end of the word
		if (ReservedWords.contains(word)) {
			symbolArr[symbolPtr] = '*';
		} else { // else it is a identifier so we add '@' at the end of the word
			symbolArr[symbolPtr] = '@';
		}
		symbolPtr++;
	}
	
	// check every line and go through every characters of a line and separate the identifiers 
	public static void lineProcessor(String str) {
		char p, c;
		String newWord = "";

		for (int i = 0; i < str.length(); i++) {
			p = str.charAt(i);

			if (p == '.' || p == '(' || p == ')' || p == '{' || p == '}'
					|| p == '\'' || p == ';' || p == ',' || p == '+'
					|| p == '-' || p == '[' || p == ']' || p == '!' || p == '>'
					|| p == '<' || p == '&' || p == '@' || p == '?' || p == '"'
					|| p == ':' || p == '|' || p == '%' || p == ' ' || p == '*'
					|| p == '=' || p == '#' || p == '/' || p == '\n') {

				// each word in file 2
				//Make sure the word doesn't start with a number because the identifier does not start w/ a number
				if (!(newWord == "")) {

					c = newWord.charAt(0);
					if (c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9') {
						newWord = "";
					} else {
						if (ReservedWords.contains(newWord)) {
							System.out.print(newWord + "* ");

						} else {
							// if it is a reserved word add * , and otherwise add @ which means it is a identifier
							if (eachWirdOfFile2.contains(newWord)) {
								System.out.print(newWord + "@ ");
							} else {
								System.out.print(newWord + "? ");
							}
						}
						eachWirdOfFile2.add(newWord);
						newWord = "";
					}
				}

			} else {
				newWord = newWord + p;
			}
		}
		System.out.println();
	}
	// read the char and return with the corresponding index
	public static int getTheIndexOfCharacter(char ch) {
		char[] lowerCase = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		char[] uperCase = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };

		if ((Character.toString(ch)).matches(".*[A-Z].*")) {
			for (int i = 0; i < 26; i++) {
				if (ch == uperCase[i]) {
					return i;
				}
			}
		} else if ((Character.toString(ch)).matches(".*[a-z].*")) {
			for (int i = 0; i < 26; i++) {
				if (ch == lowerCase[i]) {
					return i + 26;
				}
			}
		} else if (ch == '_') {
			return 52;
		} else if (ch == '$') {
			return 53;
		}
		return -1;
	}
	// Print all the arrays and the Characters 
	private static void print() {
		System.out.print("       ");
		for (int i = 0; i < 20; i++) {
			System.out.printf("%6s", (char) (i + 65));
		}

		System.out.print("\nswitch:");
		for (int i = 0; i < 20; i++) {
			System.out.printf("%6s", switchh[i]);
		}
		System.out.println("\n");

		System.out.print("       ");
		for (int i = 20; i < 26; i++) {
			System.out.printf("%6s", (char) (i + 65));
		}

		for (int i = 26; i < 40; i++) {
			System.out.printf("%6s", (char) (i + 71));
		}

		System.out.print("\nswitch:");
		for (int i = 20; i < 40; i++) {
			System.out.printf("%6s", switchh[i]);
		}
		System.out.println("\n");

		System.out.print("       ");
		for (int i = 40; i < 52; i++) {
			System.out.printf("%6s", (char) (i + 71));
		}
		System.out.printf("%6s%6s", '_', '$');

		System.out.print("\nswitch:");
		for (int i = 40; i < 54; i++) {
			System.out.printf("%6s", switchh[i]);
		}
		System.out.println("\n\n");

		for (int j = 0; j <= (symbolPtr / 20); j++) {	// we only print all the way as we need it by using the pointer as a
			System.out.print("       ");				// guide line instead of printing the whole array of 5000 chars
			for (int i = 0; i < 20; i++) {
				System.out.printf("%5d", (i + (j * 20)));
			}

			System.out.print("\nsymbol:");
			for (int i = 0; i < 20; i++) {
				System.out.printf("%5s", symbolArr[(i + (j * 20))]);
			}

			System.out.print("\n  next:");
			for (int i = 0; i < 20; i++) {
				System.out.printf("%5s", next[(i + (j * 20))]);
			}
			System.out.println("\n");
		}

	}

}