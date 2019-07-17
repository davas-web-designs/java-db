
# JAVA DB
## Steps to build a db application:

1. Stablish connection with db
2. Create an Statement object
3. Execute SQL query
4. Get and read the results of the query

In the *exercise* program, which is the most "advanced" of all I am building an application to be able to make a query from a gui, but thats not it all. The interesting part of this app is the actual DB and SQl involved, due to the relations that are stablished between the different tables that compose the db. So waht I am trying at first is to introduce a number, a employeer identifier (I did this because the names were too extrange to remember xD) and get all the possible info of it.

Actually, I have another assesment, *DATA BASES* in which I also have to learn about sql, and in this example I learned the power of the JOIN clause which is beneficial because insstead of having to do a query, store intermediate results and then do another query, you just do one, a long one but it is still only one so its interesting. So then with this only clause:

```
SELECT first_name ,dept_name, title, salary FROM employees as a INNER JOIN current_dept_emp as b ON a.emp_no=b.emp_no INNER JOIN departments as c ON b.dept_no=c.dept_no INNER JOIN titles as d ON a.emp_no = d.emp_no INNER JOIN salaries as e ON a.emp_no = e.emp_no WHERE a.emp_no = ?
```

I am able to get all the fields at once, and given that it is a prepared query, it is supossed to be more efficient

At this point, I am quite happy with the app and have learned some useful stuff, but I have encountered a problem that I find interesting: When adding the salaries to the query, I get back several results, although this correspond to the same emplyee, his salary has changed in time and that means that we end up with several results other than one, it is interesting, I have to explore how to handle it more deeply. 

The DB I choose is the employees db example that MYSQL provides , and can be found here:

https://dev.mysql.com/doc/employee/en/

It was quite complicated to get this thing running specially when considering that I am not useing an ide or something of a kind, just "plain console" as I read somewhere...I say it because in order to get this running it is necesary a JDBC driver that was also a mess to get working in my os. But other than these configuration details..xD...the code is pretty easy so lets see where can we get.

In my case, to be able to run it, I open a console in the directory of my java app and do:

```
java -cp .:/usr/share/java/mysql-connector-java-8.0.16.jar classname
```

notice that the mysql-connector-java-8.0.16.jar needs to be downloaded and may vary between distros
