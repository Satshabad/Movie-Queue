I cannot say for sure that this program has no bugs I can only 
hope you don't find them. BUT if you do and the program crashes 
and won't start back up, you need to delete the "homeQueue.txt" 
and "waitingQueue.txt" from the /sav file and restart. This will 
kill off any persistent queues.

To add movies to the library, open the "movies.txt" file and add 
attributes in this order:

Title
Genre
Main actor
another actor
another actor
Director
\n (newline)

make sure there is only exactly one new line after each movie 
especially at the end of the file.

The .git repository is made available if you would like to see 
how the project developed.