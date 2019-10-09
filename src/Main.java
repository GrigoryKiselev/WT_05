import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {

        User user = new User();
        Library library = new Library();
        Book book = new Book();
        //ArrayList<Book> booklist = new ArrayList<>();

        //чтение файла!
        try {
            File file = new File("books.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            String s = line;
            while (line != null) {
                //System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
                s = s + line;
            }
            //System.out.println(s);
            //заполняем библиотеку книгами
            line = "";
            String word = "";
            int h = 1;
            for (int i = 0; i < s.length(); i++) {
                Book books = new Book(); //чтобы не перезатерались книжки
                line = line + s.charAt(i);
                while (s.charAt(i) == '|') {
                    for (int j = 0; j < line.length(); j++) {
                        word = word + line.charAt(j);
                        while ((line.charAt(j + 1) == '/') || (line.charAt(j + 1) == '|')) { //сюда докинуть ещё чек на конец структуры
                            if (h == 1) {
                                books.setTitle(word);
                                h++;
                                word = "";
                                j++;
                                break;
                            } else if (h == 2) {
                                books.setAuthor(word);
                                h++;
                                word = "";
                                j++;
                                break;
                            } else if (h == 3) {
                                books.setPageCount(Integer.parseInt(word));
                                h = 1;
                                word = "";
                                line = "";
                                //booklist.add(books);
                                library.addBook(books);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            //System.out.println(book.name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //вывод списка всех книг из ArrayList
        //for (int i = 0; i < booklist.size(); i++)
        //    System.out.println(i + ". " + booklist.get(i).name + " | " + booklist.get(i).author + " | " + booklist.get(i).pagecount);

        //for (int i = 0; i < library.bookList.size(); i++)
        //    System.out.println(i + ". " + library.bookList.get(i).name + " | " + library.bookList.get(i).author + " | " + library.bookList.get(i).pagecount);


        //выбор действия!
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("1. Книги библиотеки\n2. Мои книги\n3. Поиск в библиотеке\n4. Подарить книгу библиотеке\n");
            System.out.print("Введите номер действия: ");

            int num = in.nextInt();
            while ((num < 1) || (num > 4)) {
                System.out.print("Некорректный ввод\n");
                System.out.print("Введите номер действия: ");
                num = in.nextInt();
            }

            switch (num) {
                case (1):
                    System.out.print("Переход к коду 1\n---------------------------------\n"); //книги библиотеки
                    for (int i = 0; i < library.bookList.size(); i++)
                        System.out.println(i + ". " + library.bookList.get(i).getTitle() + " | " + library.bookList.get(i).getAuthor() + " | " + library.bookList.get(i).getPageCount());
                    System.out.print("---------------------------------\n");
                    System.out.print("1. Взять книгу\n2. Редактировать книгу\n3. Сортировать по названию (А-Я)\n4. Сортировать по автору (А-Я)\n5. Сортировать по кол-ву страниц (по возр.)\n");
                    System.out.print("Введите номер действия: ");
                    num = in.nextInt();
                    while ((num < 1) || (num > 5)) {
                        System.out.print("Неправильный ввод\n");
                        System.out.print("Введите номер действия: ");
                        num = in.nextInt();
                    }


                    switch (num) {
                        case (1):
                            System.out.print("Введите номер книги: ");
                            num = in.nextInt();

                            if ((num > library.bookList.size()) || (num < 0))
                                System.out.println("Неверный номер книги");
                            else {
                                library.bookList.get(num);
                                user.addBook(library.bookList.get(num));
                                library.deleteBook(library.bookList.get(num));
                                System.out.println("Вы взяли книгу: " + user.bookList.get(user.bookList.size() - 1).getTitle() + " | " + user.bookList.get(user.bookList.size() - 1).getAuthor() + " | " + user.bookList.get(user.bookList.size() - 1).getPageCount());
                            }
                            break;

                        case (2):
                            System.out.print("Введите номер книги: ");
                            num = in.nextInt();

                            if ((num > library.bookList.size()) || (num < 0))
                                System.out.println("Неверный номер книги");
                            else {
                                Book book1 = new Book();
                                in.nextLine();
                                System.out.print("Введите новое название книги: ");
                                library.bookList.get(num).setTitle(in.nextLine());

                                System.out.print("Введите нового автора: ");
                                library.bookList.get(num).setAuthor(in.nextLine());
                                System.out.print("Введите новое кол-во страниц: ");
                                library.bookList.get(num).setPageCount(Integer.parseInt(in.nextLine()));


                                System.out.println("Книга была изменена");
                                System.out.print("---------------------------------\n");

                            }
                            break;

                        case (3):
                            System.out.print("Отсортировано по названию книги: \n");
                            library.sortBooksByTitle(library);
                            for (int i = 0; i < library.bookList.size(); i++)
                                System.out.println(i + ". " + library.bookList.get(i).getTitle() + " | " + library.bookList.get(i).getAuthor() + " | " + library.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;

                        case (4):
                            System.out.print("Отсортировано по автору книги: \n");
                            library.sortBooksByAuthor(library);
                            for (int i = 0; i < library.bookList.size(); i++)
                                System.out.println(i + ". " + library.bookList.get(i).getTitle() + " | " + library.bookList.get(i).getAuthor() + " | " + library.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;

                        case (5):
                            System.out.print("Отсортировано по количеству страниц книги: \n");
                            library.sortBooksByPages(library);
                            for (int i = 0; i < library.bookList.size(); i++)
                                System.out.println(i + ". " + library.bookList.get(i).getTitle() + " | " + library.bookList.get(i).getAuthor() + " | " + library.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;
                    }
                    break;

                case (2):
                    System.out.print("Переход к коду 2\n"); //мои книги
                    for (int i = 0; i < user.bookList.size(); i++)
                        System.out.println(i + ". " + user.bookList.get(i).getTitle() + " | " + user.bookList.get(i).getAuthor() + " | " + user.bookList.get(i).getPageCount());
                    System.out.print("---------------------------------\n");
                    System.out.print("1. Сортировать по названию (А-Я)\n2. Сортировать по автору (А-Я)\n3. Сортировать по кол-ву страниц (по возр.)\n");
                    System.out.print("Введите номер действия: ");
                    num = in.nextInt();


                    switch (num) {
                        case (1):
                            System.out.print("Отсортировано по названию книги: \n");
                            user.sortBooksByTitle(user);
                            for (int i = 0; i < user.bookList.size(); i++)
                                System.out.println(i + ". " + user.bookList.get(i).getTitle() + " | " + user.bookList.get(i).getAuthor() + " | " + user.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;

                        case (2):
                            System.out.print("Отсортировано по автору книги: \n");
                            user.sortBooksByAuthor(user);
                            for (int i = 0; i < user.bookList.size(); i++)
                                System.out.println(i + ". " + user.bookList.get(i).getTitle() + " | " + user.bookList.get(i).getAuthor() + " | " + user.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;

                        case (3):
                            System.out.print("Отсортировано по количеству страниц книги: \n");
                            user.sortBooksByPages(user);
                            for (int i = 0; i < user.bookList.size(); i++)
                                System.out.println(i + ". " + user.bookList.get(i).getTitle() + " | " + user.bookList.get(i).getAuthor() + " | " + user.bookList.get(i).getPageCount());
                            System.out.print("---------------------------------\n");
                            break;

                    }
                    break;

                case (3):
                    Library library1 = new Library();
                    String tag;
                    library1.bookList.clear();
                    System.out.print("Переход к коду 3\n");
                    System.out.print("1. Поиск по названию\n2. Поиск по автору \n3. Поиск по кол-ву страниц\n");
                    System.out.print("Введите номер действия: ");
                    num = in.nextInt();

                    switch (num) {
                        case (1):
                            System.out.print("Введите название книги: \n");
                            tag = in.nextLine();
                            tag = in.nextLine();
                            for (int i = 0; i < library.bookList.size(); i++)
                                if (tag.equals(library.bookList.get(i).getTitle())) {
                                    library1.addBook(library.bookList.get(i));
                                }

                            if (library1.bookList.size() != 0) {
                                System.out.print("Найденные книги: \n");
                                for (int i = 0; i < library1.bookList.size(); i++)
                                    System.out.println(i + ". " + library1.bookList.get(i).getTitle() + " | " + library1.bookList.get(i).getAuthor() + " | " + library1.bookList.get(i).getPageCount());
                            } else {
                                System.out.print("Книг не найдено: \n");
                            }

                            System.out.print("---------------------------------\n");
                            break;

                        case (2):
                            System.out.print("Введите автора книги: \n");
                            tag = in.nextLine();
                            tag = in.nextLine();
                            for (int i = 0; i < library.bookList.size(); i++)
                                if (tag.equals(library.bookList.get(i).getAuthor())) {
                                    library1.addBook(library.bookList.get(i));
                                }

                            if (library1.bookList.size() != 0) {
                                System.out.print("Найденные книги: \n");
                                for (int i = 0; i < library1.bookList.size(); i++)
                                    System.out.println(i + ". " + library1.bookList.get(i).getTitle() + " | " + library1.bookList.get(i).getAuthor() + " | " + library1.bookList.get(i).getPageCount());
                            } else {
                                System.out.print("Книг не найдено: \n");
                            }

                            System.out.print("---------------------------------\n");
                            break;

                        case (3):
                            System.out.print("Введите количество страниц книги: \n");
                            int tagg = in.nextInt();
                            for (int i = 0; i < library.bookList.size(); i++)
                                if (tagg == library.bookList.get(i).getPageCount()) {
                                    library1.addBook(library.bookList.get(i));
                                }

                            if (library1.bookList.size() != 0) {
                                System.out.print("Найденные книги: \n");
                                for (int i = 0; i < library1.bookList.size(); i++)
                                    System.out.println(i + ". " + library1.bookList.get(i).getTitle() + " | " + library1.bookList.get(i).getAuthor() + " | " + library1.bookList.get(i).getPageCount());
                            } else {
                                System.out.print("Книг не найдено: \n");
                            }

                            System.out.print("---------------------------------\n");
                            break;
                    }
                    break;

                        case (4):
                            System.out.print("Переход к коду 4\n"); //создание книги

                            System.out.print("1. Подарить книгу библиотеке\n");
                            System.out.print("2. Вернуться\n");
                            boolean f = false;
                            while ((num < 1) || (num > 2)) {
                                if (f)
                                    System.out.print("Неправильный ввод\n");
                                f = true;
                                System.out.print("Введите номер действия: ");
                                num = in.nextInt();
                            }

                            if (num == 2) //return
                                break;

                            System.out.print("Введите название книги: ");
                            in.nextLine();
                            book.setTitle(in.nextLine());

                            System.out.print("Введите автора: ");
                            book.setAuthor(in.nextLine());
                            System.out.print("Введите кол-во страниц: ");
                            book.setPageCount(in.nextInt());

                            try (FileWriter writer = new FileWriter("books.txt", true)) {
                                // запись всей строки
                                String text = book.getTitle() + "/" + book.getAuthor() + "/" + book.getPageCount() + "|";
                                writer.write(text);
                                writer.flush();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }

                            library.addBook(book);
                            break;
                    }
            }
        }
    }
