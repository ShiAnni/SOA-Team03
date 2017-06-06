import GenerateScoreList.ScoreList;
import GenerateStudentList.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


public class Generator {
    /** 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(Generator.class);

    /** Marshaller */
    private Marshaller marshaller;

    /** Unmarshaller */
    private Unmarshaller unmarshaller;

    /**
     * @return 获取 marshaller属性值
     */
    public Marshaller getMarshaller() {
        return marshaller;
    }

    /**
     * @param marshaller 设置 marshaller 属性值为参数值 marshaller
     */
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    /**
     * @return 获取 unmarshaller属性值
     */
    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    /**
     * @param unmarshaller 设置 unmarshaller 属性值为参数值 unmarshaller
     */
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    /**
     * 将对象转换输出为xml文件
     *
     * @param object object 对象
     * @param filename filename 文件名
     * @throws IOException IOException IO异常
     */
    public void writeObjectToXml(Object object, String filename) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new StreamResult(fos));
        } catch (JAXBException e) {
            LOG.error("Xml-Serialization failed due to an XmlMappingException.", e);
        } catch (IOException e) {
            LOG.error("Xml-Serialization failed due to an IOException.", e);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 将xml文件转换成java对象
     *
     * @param filename filename 文件名称
     * @return Object 转换后的java对象
     * @throws IOException IOException IO异常
     * @throws JAXBException JAXBException JAXB异常
     */
    public Object readObjectFromXml(String filename) throws IOException, JAXBException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            return unmarshaller.unmarshal(new StreamSource(fis));
        } catch (IOException e) {
            LOG.error("Xml-Deserialization failed due to an IOException.", e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return null;
    }

    /**
     * 测试用例
     *
     * @param args 传入参数
     * @throws IOException IOException
     * @throws JAXBException JAXBException
     */
    public static void main(String[] args)  {



        try {
            generateFile2();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            generateFile3();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void generateFile2() throws JAXBException, IOException {
        String[] idList = {"141250010", "141250122", "141250146", "141250176", "141250150", "141250209", "141250171", "141250162", "141250170", "141250121"};
        String[] names = new String[]{
                "陈欢", "谭琼", "王子安", "于海强", "伍佳艺", "周小帆", "姚朋", "徐文杰", "杨宇宁", "谭期友"
        };
        String[] genderList = {"男", "女", "男", "男", "男", "女", "男", "男", "女", "男"};
        String[] phoneList = {"13087211123", "13585178653", "13115872838", "13688776788", "13908991788",
                "15213519368", "15186897677", "18909178654", "15208190899", "13666325878"};
        String[] addressList = {"江苏省南京市汉口路1号", "江苏省南京市汉口路2号", "江苏省南京市汉口路3号", "江苏省南京市汉口路4号", "江苏省南京市汉口路5号",
                "江苏省南京市汉口路6号", "江苏省南京市汉口路7号", "江苏省南京市汉口路8号", "江苏省南京市汉口路9号", "江苏省南京市汉口路10号"};
        String[] courses = new String[] {
                "软件工程","体系结构","人机交互","测试开发","SOA程序设计"
        };
        String[] types = new String[] {
                "平时成绩","期末成绩","总评成绩"
        };

        JAXBContext objJaxbContext1 = JAXBContext.newInstance(Student.class);
        Marshaller objMarshaller1 = objJaxbContext1.createMarshaller();
        Unmarshaller objUnmarshaller1 = objJaxbContext1.createUnmarshaller();
        Generator test1 = new Generator();
        test1.setUnmarshaller(objUnmarshaller1);
        Student student1  = (Student) test1.readObjectFromXml("xml/文档1.xml");
        System.out.println(student1.getStudentName()+":"+student1.getStudentId());


        StudentList listObject = new StudentList();
        List<Student> studentList = new ArrayList<Student>(12);
        studentList.add(student1);
        for(int i = 0; i < names.length; i++){
            Student student = new Student(idList[i], names[i],genderList[i],phoneList[i],addressList[i]);
            student.setStudentScore(new ArrayList<StudentScore>());
            for(int j = 0; j < courses.length; j++){
                String course = courses[j];
                List<CourseScore> courseScoreList = new ArrayList<CourseScore>();
                for(int k = 0; k<types.length; k++){
                    String type = types[k];
                    CourseScore courseScore = new CourseScore("0000"+(j+1), type);
                    Score score = new Score(idList[i],new Random().nextInt(100));
                    courseScore.setScores(new ArrayList<Score>());
                    courseScore.getScores().add(score);
                    courseScoreList.add(courseScore);
                }
                StudentScore studentScore = new StudentScore(courseScoreList);
                student.getStudentScore().add(studentScore);
            }
            studentList.add(student);
        }
        listObject.setStudent(studentList);
        JAXBContext objJaxbContext = JAXBContext.newInstance(StudentList.class);
        Marshaller objMarshaller = objJaxbContext.createMarshaller();
        Unmarshaller objUnmarshaller = objJaxbContext.createUnmarshaller();

        Generator test = new Generator();
        test.setMarshaller(objMarshaller);
        test.writeObjectToXml(listObject,"xml/文档2.xml");
        test.setUnmarshaller(objUnmarshaller);
    }

    public static void generateFile3() throws JAXBException, IOException {
        //首先从文档2读取学生成绩列表，然后转换为ScoreList格式的文档
        JAXBContext objJaxbContext = JAXBContext.newInstance(StudentList.class);
        Marshaller objMarshaller = objJaxbContext.createMarshaller();
        Unmarshaller objUnmarshaller = objJaxbContext.createUnmarshaller();
        Generator test = new Generator();
        test.setUnmarshaller(objUnmarshaller);
        StudentList listObject  = (StudentList) test.readObjectFromXml("xml/文档2.xml");
        List<Student> students = listObject.getStudent();
        HashMap<String,List<CourseScore>> scoreMap = new HashMap<String, List<CourseScore>>();
        for(Student student : students){
            for(int j=0; j<student.getStudentScore().size(); j++){
                StudentScore studentScore = student.getStudentScore().get(j);
                if(studentScore != null){
                    for(int i=0; i<studentScore.studentScore.size(); i++){
                        CourseScore courseScore = studentScore.studentScore.get(i);
                        if(scoreMap.get(courseScore.getCourseId()+courseScore.getScoreType()) == null){
                            List<CourseScore> courseScoreList = new ArrayList<CourseScore>();
                            scoreMap.put(courseScore.getCourseId()+courseScore.getScoreType(), courseScoreList);
                        }
                        scoreMap.get(courseScore.getCourseId()+courseScore.getScoreType()).add(courseScore);
                    }
                }
            }
        }
        ScoreList scoreList = new ScoreList(new ArrayList<CourseScore>());

        for(List<CourseScore> list : scoreMap.values()){
            CourseScore firstScore = list.get(0);
            for(int i=1; i<list.size(); i++){
                CourseScore otherScore = list.get(i);
                firstScore.getScores().add(otherScore.getScores().get(0));
            }
            scoreList.courseScoreList.add(firstScore);
        }

        //序列化scoreList
        objJaxbContext = JAXBContext.newInstance(ScoreList.class);
        objMarshaller = objJaxbContext.createMarshaller();
        test.setMarshaller(objMarshaller);
        test.writeObjectToXml(scoreList,"xml/文档3.xml");

        List<CourseScore> list=scoreList.courseScoreList;
        List<CourseScore> courseScoreList=new ArrayList<CourseScore>();
        for(CourseScore courseScore:list){
            List<Score> scores=courseScore.getScores();
            scores=sort((ArrayList<Score>) scores);
            courseScore.setScores(scores);
            courseScoreList.add(courseScore);

        }
        scoreList.setCourseScoreList(courseScoreList);
        Iterator<CourseScore> iterator = scoreList.courseScoreList.iterator();
        while (iterator.hasNext()) {
            if(existFail(iterator.next()))
                iterator.remove();
        }
        test.writeObjectToXml(scoreList,"xml/文档4.xml");
    }

    public static boolean existFail(CourseScore courseScore) {
        List<Score> scores = courseScore.getScores();
        for(Score score : scores) {
            if(score.getScoreValue() < 60)
                return false;
        }
        return true;
    }

    public static ArrayList<Score> sort(ArrayList<Score> scores){
        ArrayList<Score> scores1=new ArrayList<Score>();
        int temp=0;
        int[] ints=new int[scores.size()];
        for(int i=0;i<scores.size();i++){
                ints[temp]=scores.get(i).getScoreValue();
                temp++;
        }
        Arrays.sort(ints);
        for(int i=0;i<ints.length;i++){
           for(Score score:scores){
               if(score.getScoreValue()==ints[i]){
                   if(!scores1.contains(score)){
                       scores1.add(score);
                      // System.out.println(ints[i]);
                   }
               }
           }
        }
        return  scores1;
    }

}
