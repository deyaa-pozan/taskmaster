# Taskmaster Android App:

This App will contains tasks to do.. and you can add tasks and display your all tasks
There ara three main activities:

1. `MainActivity`: (The home page which from it you can go to add a new task or to see the all tasks)
2. `AddTaskActivity`: (The page which let you add a new task)
3. `AllTasksActivity`: (The page which displays the all tasks for you).

### _________________________________

***For first day changes (lab 26):***

* created the three activities and add the appropriate components inside them.
* connect them with the buttons in the MainActivity(Add Task, All Tasks).
* No functionalities yet, except the move on the activities using the previous two buttons

*Screenshots:*

MainActivity:

![Screenshot1](./screens/Screenshot1.png)



AddTaskActivity:

![Screenshot2](./screens/Screenshot2.png)


AllTasksActivity:

![Screenshot3](./screens/Screenshot3.png)


### _________________________________


***For second day changes (lab 27):***

* update the home page (Main Activity) to be contains main title which hold the user name (which is set by user from the settings page) and three tasks buttons, and one button for settings.
* Add TaskDetailActivity that contains title (from the tapped button of the home page), and hard coded description for now.
* Add SettingsActivity, which contain field to enter the userName, and save button to save the user name in the sharedPreferences.. to persist and access this name from the homePage.

*Screenshots:*

MainActivity:

![Screenshot3](./screens/Screenshot4-lab27.png)


TaskDetailsActivity:

![Screenshot3](./screens/Screenshot2-lab27.png)


SettingsActivity:

![Screenshot3](./screens/Screenshot3-lab27.png)

MainActivity:

![Screenshot3](./screens/Screenshot1-lab27.png)

### _________________________________


***Third day's changes (lab 28):***

* update the home page (Main Activity) to be contains main title which hold the user name (which is set by user from the settings page) and RecyclerView which hold the list of tasks and view it as a list for the user, and one button for settings.
* create a fragment to hold the style for each task..(title, body, state)
* create taskAdapter for binding the data with the view(fragment styles)
* connect them together and set onClick listener on each ViewHolder to response for user click and go on the task details page with the title of the tapped task

*Screenshots:*

MainActivity:

![Screenshot1](./screens/Screenshot1-lab28.jpg)



TaskDetailsActivity:

![Screenshot2](./screens/Screenshot2-lab28.jpg)



### _________________________________




