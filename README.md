<h2>В проекте реализованы UI тесты для <a href='https://mir-kvestov.ru'>сайта "Мир квестов"</a></h2>

<h3>Содержание</h3>
> ➠ [Запуск тестов из терминала](#запуск-тестов-из-терминала)
>
> ➠ [Запуск тестов в Jenkins](#-удаленный-запуск-тестов-в-Jenkins)


<h2><a name='projectStack'>:book:Стек проекта:</a></h2>
<p align="center">
    <a href="#"><img title="Java" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/java.svg" width="30px href='https://mir-kvestov.ru'"/></a>
    <a href="#"><img title="Gradle" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Gradle.svg" width="50px"/></a>
    <a href="#"><img title="JUnit5" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/JUnit5.svg" width="50px"/></a>
    <a href="#"><img title="Selenide" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Selenide.svg" width="50px"/></a>
    <a href="#"><img title="Allure_Report" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Allure_Report.svg" width="50px"/></a>
    <a href="#"><img title="Jenkins" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jenkins.svg" width="50px"/></a>
    <a href="#"><img title="Selenoid" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Selenoid.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/AllureTestOps.svg" width="50px"/></a>
    <a href="#"><img title="Jira" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jira.svg" width="50px"/></a>
    <a href="#"><img title="Telegram" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Telegram.svg" width="50px"/></a>
</p>

<ul>
	<li>Java - используется как основной язык для написания тестов</li>
	<li>Gradle - используется для сборки проекта</li>
	<li>Junit5 - тестовый фремворк</li>
	<li>Selenide - библиотека для работы с UI элементами страницы</li>
  <li>RestAssured - библиотека для работы с API</li>
	<li>Allure - для формирования отчетов</li>
	<li>Jenkins - используется для запуска тестов</li>
	<li>Selenoid - используется для создания контейнеров для прохождения тестов</li>
	<li>AllureTestOps - система управления тестовыми сценариями</li>
	<li>Jira - для прикрепления отчета о тестировании в фичу команды</li>
	<li>Telegram - для информировании о результатах тестов</li>
</ul>



<h2>:book:<a name='projectArchitecture'>Архитектура проекта</a></h2>
Архитектура проекта состоит из 7 основных модулей
<ol>
    <li>
        <b>OwnerConfig</b> - конфигурационные файлы проекта, в которых может содержаться информация о среде выполнения теста и данные необходимые для работы теста.
        Данные для конфига берутся из .properties файла в ресурсах проекта, а так же из параметров запущенного теста.
    </li>
    <li>
        <b>TestBase</b> - базовый класс с конфигурацией от которого наследуются все классы с тестами. Содержит методы BeforeEach и AfterEach.
    </li>
    <li>
        <b>Tests</b> - классы описывающие логику работы теста, основываясь на бизнесс требованиях. Тесты разделены на страничные (главная, страница квеста) и функциональные (сортировка, сравнение).
    </li>
    <li>
        <b>PageObjects</b> - класс для описания страницы приложения. Поля класса объявляются как приватные константы и описывают селекторы для необходимых элементов.
        Взаимодействие с классом происходит за счет публичных методов класса, использующих ранее описанные селекторы.
    </li>
    <li>
        <b>Components</b> - класс для описания логики работы с часто используемыми элементами страницы. (таблица с результатами поиска...)
    </li>
    <li>
        <b>TestData</b> - класс, в который вынесены передаваемые в методы переменные (строковые и числовые) 
    </li>
</ol>


<h2><a name='runningTests'>Запуск тестов</a></h2>

<h3>:book:<a name='runningTestsLocal'>Запуск тестов локально</a></h3>

Для запуска тестов локально используется команда : <b>gradle clean ....</b>

<p><b>-Durl</b> - ссылка на стенд приложения UI</p>
<p><b>-DapiUrl</b> - ссылка на стенд приложения API</p>
<p><b>-Dbrowser</b> - браузер для запуска тестов UI</p>

Так же необходимо указать токен бота и чат в который должны приходить уведомление в телеграмм. Для этого нужно
отредактировать файл: <b>notifications/telegram.json</b>
