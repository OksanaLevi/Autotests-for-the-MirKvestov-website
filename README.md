<h2>В проекте реализованы UI тесты для <a href='https://mir-kvestov.ru'>сайта "Мир квестов"</a></h2>

## Содержание

> ➠ [Стэк и архитектура проекта](#стэк-проекта)
>
> ➠ [Запуск тестов из терминала](#запуск-тестов-из-терминала)
>
> ➠ [Запуск тестов в Jenkins](#запуск-тестов-в-Jenkins)
>
> ➠ [Отчет о результатах тестирования в Allure Report](#allure-отчет)
> 
> ➠ [Тестовая документация в Allure Test Ops](#тк-в-allure-test-ops)
> 
> ➠ [Тестовая документация в Jira](#тк-в-jira)
> 
> ➠ [Отправка результатов запуска в Telegram](#уведомления-в-telegram)
> 
> ➠ [Видео-пример запуска теста в Selenoid](#пример-запуска-теста-в-selenoid)


<h2>:package:<a name='стэк-проекта'>Стек проекта:</a></h2>
<p align="center">
    <a href="https://www.java.com/""><img title="Java" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/java.svg" width="30px href='https://mir-kvestov.ru'"/></a>
    <a href="https://gradle.org/"><img title="Gradle" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Gradle.svg" width="50px"/></a>
    <a href="https://junit.org/junit5/"><img title="JUnit5" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/JUnit5.svg" width="50px"/></a>
    <a href="https://selenide.org/"><img title="Selenide" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Selenide.svg" width="50px"/></a>
    <a href="https://github.com/allure-framework"><img title="Allure_Report" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Allure_Report.svg" width="50px"/></a>
    <a href="https://www.jenkins.io/"><img title="Jenkins" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jenkins.svg" width="50px"/></a>
    <a href="https://aerokube.com/selenoid/"><img title="Selenoid" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Selenoid.svg" width="50px"/></a>
    <a href="https://qameta.io/"><img title="Allure Test Ops" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/AllureTestOps.svg" width="50px"/></a>
    <a href="https://www.atlassian.com/ru/software/jira"><img title="Jira" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jira.svg" width="50px"/></a>
    <a href="https://web.telegram.org/"><img title="Telegram" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Telegram.svg" width="50px"/></a>
</p>

<ul>
	<li>Java - используется как основной язык для написания тестов</li>
	<li>Gradle - используется для сборки проекта</li>
	<li>Junit5 - тестовый фремворк</li>
	<li>Selenide - библиотека для работы с UI элементами страницы</li>
	<li>Allure - для формирования отчетов</li>
	<li>Jenkins - используется для запуска тестов</li>
	<li>Selenoid - используется для создания контейнеров для прохождения тестов</li>
	<li>AllureTestOps - система управления тестовыми сценариями</li>
	<li>Jira - для прикрепления отчета о тестировании в фичу команды</li>
	<li>Telegram - для информировании о результатах тестов</li>
</ul>



<h2>:notebook_with_decorative_cover:<a name='архитектура-проекта'>Архитектура проекта</a></h2>
Архитектура проекта состоит из 5 основных модулей
<ol>
    <li>
        <b>TestBase</b> - базовый класс с конфигурацией от которого наследуются все классы с тестами. Содержит методы <code>BeforeEach</code> и <code>AfterEach</code>.
    </li>
    <li>
        <b>Tests</b> - классы описывающие логику работы теста, основываясь на бизнесс требованиях. Тесты разделены на страничные (главная, страница квеста) и функциональные (сортировка, сравнение).
    </li>
    <li>
        <b>PageObjects</b> - класс для описания страницы приложения. Поля класса объявляются как приватные константы и описывают селекторы для необходимых элементов.
        Взаимодействие с классом происходит за счет публичных методов класса, использующих ранее описанные селекторы.
    </li>
    <li>
        <b>Components</b> - класс для описания логики работы с часто используемыми элементами страницы (таблица с результатами поиска)
    </li>
    <li>
        <b>TestData</b> - класс, в который вынесены передаваемые в методы переменные (строковые и числовые) 
    </li>
</ol>


<h2>:hammer:<a name='запуск-тестов-из-терминала'>Запуск тестов</a></h2>

<h3><a>Запуск тестов из терминала</a></h3>
Если gradle установлен на локальный комп:

```
gradle clean test
```

Если не установлен (минимальная версия локальной java - 17):

```
./gradlew clean test
```


<h3><a href="https://www.jenkins.io/"><img width="4%" title="Jenkins" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jenkins.svg"></a><a name='запуск-тестов-в-Jenkins'>Запуск тестов в Jenkins</a></h3>

Для запуска тестов используется <a href='https://jenkins.autotests.cloud/job/building_UI_WEB_autotests_OksanaL/'>параметризированная сборка</a>

<h3><a href="https://github.com/allure-framework"><img width="4%" title="Allure_Report" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Allure_Report.svg"></a><a name='allure-отчет'>Отчет о результатах тестирования в Allure Report</a></h3>

<p>
<img width="90%" title="Allure_Report" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/screens/allure_report.svg">
</p>

<h3><a href="https://qameta.io/"><img width="4%" title="Allure_TestOps" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/AllureTestOps.svg"></a><a name='тк-в-allure-test-ops'>Тестовая документация в Allure TestOps</a></h3>

<p>
<img width="90%" title="Allure_TestOps" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/screens/Allure_TestOps.svg">
</p>

<h3><a href="https://www.atlassian.com/ru/software/jira"><img width="4%" title="Jira" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Jira.svg"></a><a name='тк-в-jira'>Тестовая документация в Jira</a></h3>
В <code>Allure TestOps</code> настроена интеграция с <code>Jira</code>. Благодаря этому можно прикрепить тестовую модель к тикету в <code>Jira</code>, а также перейти по гиперрсылке для ознакомления с результатами запусков.

Так выглядят прикрепленные тест-кейсы к тикету в <code>Jira</code>:

<p>
<img width="70%" title="Jira_task_with_test_case" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/screens/Jira_task_with_test_case.svg">
</p>

Есть возможность по клику на тест ознакомиться с его шагами:

<p>
<img width="65%" title="Jira_steps_test_case" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/screens/Jira_steps_test_case.svg">
</p>

<h3><a href="https://web.telegram.org/"><img width="4%" title="Telegram" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Telegram.svg"></a><a name='уведомления-в-telegram'>Отправка результатов запуска в Telegram</a></h3>
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.
С информацией по настройке и использованию бота можно ознакомиться <a href='https://github.com/qa-guru/allure-notifications'>по ссылке</a> 
<p>
<img width="50%" title="message_telegram" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/screens/telegram_message.svg">
</p>

<h3><a href="https://aerokube.com/selenoid/"><img width="4%" title="Selenoid_UI" src="https://github.com/OksanaLevi/OksanaLevi/blob/main/logo/Selenoid.svg"></a><a name='пример-запуска-теста-в-selenoid'>Пример запуска тестов в Selenoid</a></h3>
К каждому тесту в <code>Allure-отчете</code> прилагается видео.
Видео запуска UI-теста:

<p>
<img title="Selenoid_gif" src="https://github.com/OksanaLevi/Autotests-for-the-MirKvestov-website/blob/main/readme_design/gifs/Sorting_test.gif">
</p>
