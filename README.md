# crawler-full-stack-app

Вам необходимо написать сервис, который будет рекурсивно обходить web-страницу, и предоставлять список из:

* Картинок с этой страницы
* Топ-5 слов

Необходимо рекурсивно обходить ссылки, находящиеся на странице

Сервис должен состоять из 3 частей:

## Клиент

Пользователю должен быть доступен сайт со следующим функционалом:

* Возможность регистрации и авторизации
* Запуск преобразования в визуальное представление и его просмотр
* Сохранение в избранное
* Просмотр избранного

Сайт должен иметь хоть какие-то css-стили и выглядеть адекватно, html в котором все свалено в углу в кучу засчитан не
будет. Генерация страницы должна производиться с помощью kotlin-js.

## Сервер

Должен быть бэкэнд, обрабатывающий запросы от клиента - именно он должен осуществлять обход страницы и подсчет
статистики. Обход ссылок внутри страницы должен быть распараллелен на несколько потоков с использованием корутин.
Подробнее о представлении:

* Обход ссылок совершается до определенной глубины `d`, которая обозначается `сложностью` и задается пользователем
* Топ считается относительно веса слов. Вес считается как
  `w = n_d * d * (1 - log(d + 1))`, где
  `d` - глубина страницы. Если страница встречается несколько раз на разной глубине - берется минимальная.
  `n_d` - количество вхождений на данной глубине.

## Database

В базе должны хранится пользователи и их избранное. Картинки должны храниться в виде ссылок, не должно быть 2ух и более
равных картинки в базе (не забудьте про транзакционность вставки). Проверять уникальность скачиванием всех существующих
в базе картинок запрещено. Для проверки "одинаковости" можете ограничиться хешами.

# Стек

Вы должны по-максимуму использовать котлин и его библиотеки - клиент должен быть написан на `kotlin-js`, сервер -
на `kotlin-jvm`. Весь общий код должен быть вынесен в мультиплатформенную часть. Если вы хотите использовать Java
библиотеку, но есть аналог на котлине для котлина - нужно использовать аналог. Например, вместо `gson`
используйте `kotlinx.serialization`, вместо `spring` - `ktor`.

Клиент должен быть написан с использованием фреймворков, например с помощью `react` - нельзя доставать сверстанный html
из ресурсов или вставлять его как строку в код

База должна быть персистентной, можете использовать `Mongo`, для нее тоже есть нормальные kotlin либы

Все хождения по интернету и общение между процессами (например, от сервера к базе) должны происходить с использованием
корутин

# Допущения

Баллы за задачу - 60

За каждое из следующих допущений вы теряете 7.5 баллов:

* Не использовать нормальную СУБД, а хранить все в текстовых файлах на диске
* Не добавлять регистрацию + авторизацию пользователей

За каждое из следующих допущений вы теряете 15 баллов:

* Не использовать js-фреймворки для верстки, а склепать html+css (но не js) и закинуть их в ресурсы

Вам необходимо набрать:

* 2 курс - `max(30, 60 - ваши баллы)`
* 3/4 курс - `max(40, 60 - ваши баллы)`

За минусы баллы не теряются, но не любой код будет принят и могут потребоваться исправления
