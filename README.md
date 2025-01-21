
# ContactsApp-java-project
My project work for *Introduction to Programming* course.

## Description
Task was to create a simple contacts application where user can
* create,
* read,
* update and
* delete Finnish contacts from a text file.

This application has a command line user interface. To save the data it uses `.csv` file (Comma-separated values).

Data types and examples of what can be saved.

    1. (Finnish) Personal ID: 131052-308T
    2. First Name: Jaakko
    3. Last Name: Vilen
    4. (Finnish) Phone Number: +3584023423
    5. Street Address: Hämeenkatu
    6. Street Number: 12
    7. Postcode: 33100
    8. (Finnish) City/Postoffice: Tampere
    9. E-mail: jaakko.vilen@gmail.com

What the application is missing is a search function and/or a line number index. I didn’t have time to implement these, but they would enhance the user experience, as line numbers are used to specify which entry to update or delete.

## Usage
The application can be compiled and started with `cd src/ && javac *.java && java ContactsApp`

You should be greeted with the text `Welcome to the Contacts Application!` after which the application initializates the `.csv` text file. Then you should see:
```
## Main menu ##
Command options: .help .readAll .readLine .create .update .delete .exit
```
From this point using the application should be quite straight forward. You can start by reading more details with `.help` and even more so inside of that with `.guide`.

## Documentation
Screencast video link: [screencast (YouTube)]([https://youtu.be/hzrnlTcgvg4])
and Html documentation generated from javadoc comments.

## Postcode data copyrights
The postcode data file [postcodes.csv](https://github.com/TimeForNano/java-project/blob/main/src/postcodes.csv), used in this project. Was generated on March 23, 2021, by Teemu Havulinna for his own project, https://github.com/ohjelmointi2/postinumerot.

The data is based on the [postcode_nap_light.json](https://github.com/theikkila/postinumerot/blob/master/postcode_map_light.json) file from Teemu Heikkilä's https://github.com/theikkila/postinumerot project.

The copyright of the data belongs to Finnish Post, Posti (Posti Group Oyj) and [it is used accordance with Posti's terms of use](https://www.posti.fi/fi/yrityksille/asiakastuki/postinumerotiedostot). If you make copies of this material, please ensure that you comply with the terms of use.
