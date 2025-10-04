package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = addCourse(registeredCourses, 2170);
        checkExistence(updatedCourses, 2170);
        checkExistence(updatedCourses, 2000);
    }
    public static int[] addCourse(int[] registeredCourses, int newCourse){
        int[] updatedCourses = new int[registeredCourses.length + 1];
        for(int i=0 ; i < registeredCourses.length ; i++ ){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[registeredCourses.length] = newCourse;
        System.out.println("Updated Courses :");
        for(int course : updatedCourses){
            System.out.println(course);
        }
        return updatedCourses;
    }
    public static void checkExistence(int[] courses,int course){
        for(int crs: courses){
            if(crs == course){
                System.out.println(course + " exists");
                return;
            }
        }
        System.out.println(course+ " doesn't exist");
    }
}
