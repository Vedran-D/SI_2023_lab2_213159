Vedran Deskovski 213159

## Control Flow Graph
![cfg](https://github.com/Vedran-D/SI_2023_lab2_213159/assets/61386261/a7cce482-6748-4007-822e-8928af44c3e8)

## Цикломатска комплексност

Цикломатска комплексност е 9, 
Број на ребра(Е) = 31, 
Број на јазли(N) = 23, 
Комплексност = 31 - 23 + 2 = 10

## Тестови според Every Branch критериум<br>
1,2 => 3<br>
1,2 => 4<br>
3 => 26<br>
4 => 5<br>
4 => 6,7<br>
5 => 6,7<br>
6,7 => 15,16,17,18<br>
5 => 8<br>
8 => 9.1<br>
9.1 => 9.2<br>
9.2 => 10,11<br>
9.2 => 15,16,17,18<br>
10,11 => 12<br>
10,11 => 13<br>
12 => 13<br>
13 => 14<br>
14 => 9.3<br>
9.3 => 9.2<br>
15,16,17,18 => 19<br>
19 => 26<br>
15,16,17,18 => 20,21<br>
20,21 => 25<br>
20,21 => 22.1<br>
22.1 => 22.2<br>
22.2 => 23<br>
22.2 => 25<br>
23 => 24<br>
23 => 22.3<br>
24 => 22.3<br>
22.3 => 22.2<br>
25 => 26<br>
Ќе ги имаме следните тест случаеви:<br>
Test 1: user = null (проверувам дали објектот е нулл)<br>
Test 2: user = User(null, password!,test@gmail.com) (дали кор. име е нулл)<br>
Test 3: user = User(username1, password!, test@gmail.com) (овој корисник е „совршен“, затоа што има име, пасворд со спец. карак. и емаил со потребните знаци)<br>
Test 4: user = User(username1, password!, testgmail.com) (невалиден емаил)<br>
Test 5: user = User(username1, username1!, test@gmail.com) (невалиден пасворд)<br>
Test 6: user = User(username1, user, test@gmail.com) (големината на пасвордот е помала од 8)<br>
Test 7: user = User(username1, username1 !, test@gmail.com) (има празно место во пасвордот)<br>
Test 8: user = User(username1, password, test@gmail.com) (пасвордот нема спец. карактер)<br>
Test 9: ако имам некој user чие што име се совпаѓа со некое име од листата на users<br>
Test 10: ако имам некој user чие што емаил адреса се совпаѓа со некоја адреса од листата на users<br>

## Тестови според Multiple Condition критериум<br>
условот е претставен на следниот начин: if (user==null || user.getPassword()==null || user.getEmail()==null)<br>
што значи дека треба да ги испитаме следните сценарија:<br>
1. T || F || F<br>
2. F || T || F<br>
3. F || F || T<br>
4. F || F || F<br>
Ќе ги имаме следните тест случаеви:<br>
Test 1: user = null<br>
Test 2: user = User(username1, null, test@gmail.com)<br>
Test 3: user = User(username1, password!, null)<br>
Test 4: user = User(username1, password!, test@gmail.com)<br>

## Објаснување на напишаните unit tests<br>
Во претходно напишаниот дел на овој ReadMe.md file и во SILab2Test.java file-от (во коментари) имам кратко објаснување за секој test case кога и зошто се користи.
