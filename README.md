# PENGU_CLASSROOM
Project description: The main objectives are user-friendly web applications for teachers and elementary children who use the app to perform normal school activities such as assigning and receiving homework and grading students. Students can receive mail because of their children's overall achievement once every month   The website can be operated in a classroom of 50 young students and 50 respective student parent or guardian representatives and used with 2 teachers. The teacher can operate multiple classrooms up to 10, likewise and be able to publish at most 50 assignments, and 50 announcements per semester, and receive student attendance reports daily and grade students' assignment.   The main use case of teachers can be teachers can post assignments in the form of text, sound, pictures to a group of students or individual students. Teachers can receive homework from students via web applications. Teachers can grade the student's homework and give feedback based on the score given.   The main use case of students can be students can receive notification that an assignment has been posted and see teacher announcements. Students can submit an assignment to teacher. Students can view the points they have been given. 
## Front end : 

#### * Run Docker 
- Download ad Run Docker Desktop: https://www.docker.com/products/docker-desktop/
- If you have the error "WSL 2 installation is incomplete":
  * Go to link: https://docs.microsoft.com/vi-vn/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package
  * Follow step 4 and 5
* Run following command in the terminal/command_prompt: 
  * ``docker pull maklisa2000/pengu_classroom:latest``
  * Check whether docker images exists: 
    * REPOSITORY: maklisa2000/pengu_classroom
    * TAG: latest
  * Run docker images: ``docker run -d -p 8081:8081 -t maklisa2000/pengu_classroom:latest``
  * Check if container maklisa2000/pengu_classroom is running: ``docker ps``
