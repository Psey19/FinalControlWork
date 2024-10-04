# Итоговая контрольная работа
## Операционные системы и виртуализация (Linux)
### 1. Использование команды cat в Linux
   - Создать два текстовых файла: "Pets" (Домашние животные) и "Pack animals" (Вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
   
```sh
mkdir TestWork
cd TestWork/
cat > Pets.txt
cat > Pack_Animals.txt
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/1.png)

   - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
   Переименовать получившийся файл в "Human Friends".
```sh
cat Pets.txt Pack_Animals.txt > Human_Friends.txt
cat Human_Friends.txt
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/2.png)

### 2. Работа с директориями в Linux
- Создать новую директорию и переместить туда файл "Human Friends".
```sh
cd
mkdir ControlWork
cd TestWork/
mv Human_Friends.txt ~/ControlWork/
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/3.png)

### 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
- Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.

```sh
cd
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
ls -fla | grep mysql
sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
sudo apt-get update
sudo apt-get install mysql-server
systemctl status mysql
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/4.png)

### 4. Управление deb-пакетами
- Установить и затем удалить deb-пакет, используя команду `dpkg`.

```sh
sudo wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
ls -fla | grep chrome
sudo dpkg -i google-chrome-stable_current_amd64.deb
dpkg -l | grep chrome
sudo dpkg -r google-chrome-stable
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/5.png)

### 5. История команд в терминале Ubuntu
- Сохранить и выложить [историю](https://github.com/Psey19/FinalControlWork/blob/main/docs%20//Logs.txt) ваших терминальных команд в Ubuntu.

## Объектно-ориентированное программирование 

### 6. Диаграмма классов
   - Создать [диаграмму](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/Диаграмма.drawio) классов с родительским классом "Животные", и двумя подклассами: "Pets" и "Pack animals".

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20//Диаграмма.jpg)

### 7. Работа с MySQL 

### 7.1. 
- После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" должна быть структурирована в соответствии с этой диаграммой. Например, можно создать таблицы, которые будут соответствовать классам "Pets" и "Pack animals", и в этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.). 

### 7.2.
- В ранее подключенном MySQL создать базу данных с названием "Human Friends".  

```sh
CREATE DATABASE Human_Friends;
```

- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

```sh
CREATE TABLE Animal
(
Animal_Id INT PRIMARY KEY AUTO_INCREMENT,
Species VARCHAR(20) NOT NULL
);
INSERT INTO Animal (Species)
VALUES
('Pet'),
('Pack_Animal');

CREATE TABLE Pet
(
Pet_Id INT PRIMARY KEY AUTO_INCREMENT,
Type VARCHAR(20) NOT NULL,
Species_Id INT NOT NULL,
FOREIGN KEY(Species_Id) REFERENCES Animal(Animal_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Pet (Type, Species_Id)
VALUES
('Cat', 1),
('Dog', 1),
('Hamster', 1);

CREATE TABLE Pack_Animal
(
Pack_Animal_Id INT PRIMARY KEY AUTO_INCREMENT,
Type VARCHAR(20) NOT NULL,
Species_Id INT NOT NULL,
FOREIGN KEY(Species_Id) REFERENCES Animal(Animal_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Pack_Animal (Type, Species_Id)
VALUES
('Horse', 2),
('Camel', 2),
('Donkey', 2);
```
- Заполнить таблицы данными о животных, их командах и датами рождения.

```sh
CREATE TABLE Cat
(
Cat_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pet(Pet_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Cat (Name, DateBirth, Commands, Type_Id)
VALUES
('Barsik', '2021-12-14', 'Paw, Sit, Crawl', 1),
('Kesha', '2017-09-02', 'Fetch, Come', 1),
('Stepan', '2022-11-11', 'Sit, Crawl', 1);

CREATE TABLE Dog
(
Dog_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pet(Pet_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Dog (Name, DateBirth, Commands, Type_Id)
VALUES
('Bella', '2018-11-04', 'Paw, Sit, Crawl, Come', 2),
('Baron', '2020-03-22', 'Fetch, Come, Sit', 2),
('Bosik', '2022-06-07', 'Sit, Crawl, Fetch, Come', 2);

CREATE TABLE Hamster
(
Hamster_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pet(Pet_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Hamster (Name, DateBirth, Commands, Type_Id)
VALUES
('Homa', '2022-10-04', 'Stay', 3),
('Snoppy', '2023-04-18', 'Roll, Come', 3),
('Fifty', '2022-12-17', 'Drop it', 3);

CREATE TABLE Horse
(
Horse_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pack_Animal(Pack_Animal_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Horse (Name, DateBirth, Commands, Type_Id)
VALUES
('Helena', '2010-09-14', 'Trot, Jump, Walk', 1),
('Mustang', '2013-11-05', 'Walk, Gallop', 1),
('Morning Star', '2017-01-16', 'Walk, Jump, Canter', 1);

CREATE TABLE Camel
(
Camel_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pack_Animal(Pack_Animal_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Camel (Name, DateBirth, Commands, Type_Id)
VALUES
('Vasya', '2000-03-11', 'Carry Load, Walk', 2),
('Burya', '1998-10-15', 'Walk, Run', 2),
('Irisha', '1997-02-18', 'Carry Load', 2);

CREATE TABLE Donkey
(
Donkey_Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
DateBirth DATE NOT NULL,
Commands VARCHAR(50) NOT NULL,
Type_Id INT NOT NULL,
FOREIGN KEY(Type_Id) REFERENCES Pack_Animal(Pack_Animal_Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Donkey (Name, DateBirth, Commands, Type_Id)
VALUES
('Eeyore', '2002-05-19', 'Carry Load, Bray', 3),
('Glebushka', '2008-09-30', 'Walk, Kick', 3),
('Sugar', '1996-12-12', 'Carry Load', 3);
```

- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

```sh
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Camel;
SET SQL_SAFE_UPDATES = 1;

SELECT Name, DateBirth, Commands FROM Horse
UNION 
SELECT Name, DateBirth, Commands FROM Donkey;
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/db_1.png)

- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

```sh
CREATE TEMPORARY TABLE Animals1 AS 
SELECT *, 'Cat' AS Type_Animal FROM Cat
UNION 
SELECT *, 'Dog' AS Type_Animal FROM Dog
UNION 
SELECT *, 'Hamster' AS Type_Animal FROM Hamster
UNION 
SELECT *, 'Horse' as Type_Animal FROM Horse
UNION 
SELECT *, 'Donkey' AS Type_Animal FROM Donkey;


CREATE TABLE Young_Animal AS
SELECT Name, DateBirth, Commands, Type_Animal, TIMESTAMPDIFF(MONTH, DateBirth, CURDATE()) AS Age_Month
FROM Animals1 
WHERE DateBirth BETWEEN ADDDATE(CURDATE(), INTERVAL -36 MONTH) AND ADDDATE(CURDATE(), INTERVAL -12 MONTH);
 
SELECT * FROM Young_Animal;
```

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/db_2.png)


- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

```sh
SELECT c.Name, c.DateBirth, c.Commands, p.Type, a.Species, ya.Age_Month FROM Cat c
LEFT JOIN Young_Animal ya ON ya.Name = c.Name
LEFT JOIN Pet p ON p.Pet_Id = c.Type_Id
LEFT JOIN Animal a ON a.Animal_Id = p.Species_Id
UNION
SELECT d.Name, d.DateBirth, d.Commands, p.Type, a.Species, ya.Age_Month FROM Dog d
LEFT JOIN Young_Animal ya ON ya.Name = d.Name
LEFT JOIN Pet p ON p.Pet_Id = d.Type_Id
LEFT JOIN Animal a ON a.Animal_Id = p.Species_Id
UNION
SELECT ham.Name, ham.DateBirth, ham.Commands, p.Type, a.Species, ya.Age_Month FROM Hamster ham
LEFT JOIN Young_Animal ya ON ya.Name = ham.Name
LEFT JOIN Pet p ON p.Pet_Id = ham.Type_Id
LEFT JOIN Animal a ON a.Animal_Id = p.Species_Id
UNION
SELECT h.Name, h.DateBirth, h.Commands, pa.Type, a.Species, ya.Age_Month FROM Horse h
LEFT JOIN Young_Animal ya ON ya.Name = h.Name
LEFT JOIN Pack_Animal pa ON pa.Pack_Animal_Id = h.Type_Id
LEFT JOIN Animal a ON a.Animal_Id = pa.Species_Id
UNION 
SELECT d.Name, d.DateBirth, d.Commands, pa.Type, a.Species, ya.Age_Month FROM Donkey d 
LEFT JOIN Young_Animal ya ON ya.Name = d.Name
LEFT JOIN Pack_Animal pa ON pa.Pack_Animal_Id = d.Type_Id
LEFT JOIN Animal a ON a.Animal_Id = pa.Species_Id;
```
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/db_3.png)

### 8. ООП и Java
- Создать иерархию классов в Java, который будет повторять диаграмму классов созданную в задаче 6   (Диаграмма классов).

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/1-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/2-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/3-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/10-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/4-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/5-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/6-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/7-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/8-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/9-oop.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/11-oop.png)

### 9. Программа-реестр домашних животных
- Написать программу на Java, которая будет имитировать реестр домашних животных. 
Должен быть реализован следующий функционал:

### 9.1. Добавление нового животного
- Реализовать функциональность для добавления новых животных в реестр.
Животное должно определяться в правильный класс (например, "собака", "кошка", "хомяк" и т.д.)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/add1.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/add2.png)

### 9.2. Список команд животного
- Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать").

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/showCommands.png)

### 9.3. Обучение новым командам
- Добавить возможность обучать животных новым командам.

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/teachCommand.png)

### 9.4 Вывести список животных по дате рождения

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/dateBirth.png)

### 9.5. Навигация по меню
- Реализовать консольный пользовательский интерфейс с меню для навигации между вышеуказанными функциями.

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/navi1.png)
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/navi2.png)
![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/navi3.png)

### 10. Счетчик животных
- Создать механизм, который позволяет вывести на экран общее количество созданных животных любого типа (Как домашних, так и вьючных), то есть при создании каждого нового животного счетчик увеличивается на “1”. 

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/counter.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/counter2.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/counter3.png)

![](https://github.com/Psey19/FinalControlWork/blob/main/docs%20/counter4.png)


# Описание программы
- При запуске программы создаётся файл "Animal_Registry.txt", в который сохраняется список всех добавленных животных, исключены повторения. При повторном запуске программы список животных считывается из этого файла, работоспособность всех функций сохраняется. 
- Проведена работа с исключениями, учтена валидация на правильный ввод данных без завершения работы программы, до тех пор пока не будут введены верные данные. Есть возможность вводить данные на латинице и кириллице. 
- При навигации по меню есть возможность возврата в предыдущее меню, в главное меню и выхода из программы.
