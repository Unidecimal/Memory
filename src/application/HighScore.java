package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
/**
 * 
 * @author Johan
 *
 */
public class HighScore extends GameEngine {

	URL url = getClass().getResource("/savegame/highscore.txt");
	final String pathname = url.getPath();
	String[] scoreList = new String[5];

	public HighScore() {
		readFile();
	}

	// creates a BufferedReader, reads highscore file
	public void readFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(pathname));) {
			for (int i = 0; i < scoreList.length; i++) {
				scoreList[i] = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// writes highscore to file
	public void writeFile() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathname));) {

			for (int i = 0; i < scoreList.length; i++) {
				bw.write(scoreList[i]);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void updateScore(double score, int board) {
		scoreList[board] = Double.toString(score);
	}

	String getScore(int board) {
		return scoreList[board];
	}
}
