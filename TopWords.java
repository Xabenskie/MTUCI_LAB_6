import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopWords {
	public static void main(String[] args) {
		// указываем путь к файлу
		String filePath = "./file/file.txt";
		// создаем объект File
		File file = new File(filePath);
		// создаем объект Scanner для чтения файла
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		// создаем объект Map для хранения слов и их количества
		Map<String, Integer> wordCountMap = new HashMap<>();

		// читаем файл по словам и добавляем их в Map
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
			if (!word.isEmpty()) {
				wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
			}
		}

		// закрываем Scanner
		scanner.close();

		// создаем список из элементов Map
		List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

		// сортируем список по убыванию количества повторений
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// выводим топ-10 слов
		System.out.println("Top 10 words:");
		for (int i = 0; i < Math.min(10, list.size()); i++) {
			System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
		}
	}
}
