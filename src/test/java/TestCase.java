import org.legend.dao.IStudentDao;
import org.legend.entity.AllCollectionType;
import org.legend.entity.Course;
import org.legend.entity.Student;
import org.legend.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestCase {
    @Test
     public void springIoc() {
        /**
         * 面向对象方式
         */
//        Student student = new Student();
//        student.setStuName("lzg");
//        student.setStuAge(34);
//        student.setStuNo(10);
//        System.out.println(student);

        //创建spring容器，并加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器创建对象
        Student student = (Student) context.getBean("student");
        //访问对象
        System.out.println(student);
    }
    @Test
    public static void learnCourse() {
        //通过普通的new创建的ICourse子对象
        Student student = new Student();
        student.learnHtml();
        student.learnJava();
    }
    @Test
    public static void learnCourseWithFactory() {
        //通过普通的new创建的ICourse子对象
        Student student = new Student();
        student.learnCourse("javaCourse");
    }
    @Test
    public static void learnCourseWithIoc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        student.learnCourse("htmlCourse");
    }
    @Test
    public static void testDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Course course = (Course) context.getBean("course");
        course.showInfo();
    }
    @Test
    public static void collectionDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AllCollectionType type = (AllCollectionType) context.getBean("collectionDemo");
        System.out.println(type);
    }
    @Test
    public static void testAnnotationBean() {//扫描Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentDao studentDao = (IStudentDao) context.getBean("studentDao");//自动扫描
        Student student = (Student) context.getBean("student");
        studentDao.addStudent(student);
    }
    @Test
    public static void testAnnotationProperty() {//扫面注入属性
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        Student student = (Student) context.getBean("student");
        studentService.addStudent(student);
    }
    @Test
    public static void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        Student student = (Student) context.getBean("student");
        studentService.addStudent(student);//invocation.proceed()决定执不执行
        studentService.deleteStudentByName("legend");
    }

//    public static void main(String[] args) {
////        springIoc();
//        //Java程序的入口是统一的main(),因此只需要在main中实例化一次applicationContext.xml,就可以实例化“ioc容器初始化”操作
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////        learnCourse();//new
////        learnCourseWithFactory();//工厂模式
//        learnCourseWithIoc();//Ioc
////        testDI();
////        collectionDemo();
////        testAnnotationBean();
////        testAnnotationProperty();
////        testAop();
//    }
}
