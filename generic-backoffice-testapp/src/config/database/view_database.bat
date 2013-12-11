REM lancer si besoin le service mysql (net start mysql)
set MYSQL_HOME=C:\Prog\DB\MySql5
d:
cd D:\projets\frameworks\mvn-m2e-workspace\generic-backoffice-testapp\src\config\database
"%MYSQL_HOME%\bin\mysql"  -u root -p  <view_minibank_db.sql
pause