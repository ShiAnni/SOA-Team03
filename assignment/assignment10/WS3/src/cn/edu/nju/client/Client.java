package cn.edu.nju.client;

import cn.edu.nju.jw.schema.�ɼ���������;
import cn.edu.nju.jw.schema.�ɼ�����;
import cn.edu.nju.jw.schema.�γ̳ɼ�����;
import cn.edu.nju.jw.wsdl.AddScoreFault;
import cn.edu.nju.jw.wsdl.DeleteScoreFault;
import cn.edu.nju.jw.wsdl.ModifyScoreFault;
import cn.edu.nju.jw.wsdl.ScoreInterface;
import cn.edu.nju.jw.wsdl.ScoreService;
import cn.edu.nju.jw.wsdl.SearchScoreFault;


public class Client {
	public static void main(String[] args) {  
		  
		ScoreService service = new ScoreService();
        ScoreInterface itf = service.getScorePort();
        
        �γ̳ɼ����� single = new �γ̳ɼ�����();
    	�ɼ����� singlescore = new �ɼ�����();
    	singlescore.setѧ��("141250148");
    	singlescore.set�÷�(95);
        single.set�ɼ�����(�ɼ���������.ƽʱ�ɼ�);
        single.set�γ̱��("000001");
        single.get�ɼ�().add(singlescore);
        try {
			itf.addScore(single);
			System.out.println("addScoreSuccess--Client");
		} catch (AddScoreFault e) {
			System.out.println("addScoreError");
			e.printStackTrace();
		}
        try {
        	itf.searchScore("123");
        } catch (SearchScoreFault e) {
        	System.out.println("���ҵ�ѧ�Ų�����");
        }
        
        try {
        	System.out.println(itf.searchScore("141250148").get�γ̳ɼ�().size());
        	System.out.println("���ҳɹ�");
        } catch (SearchScoreFault e) {
        	e.printStackTrace();
        }
        
		try {
			itf.deleteScore(single);
			System.out.println("deleteScoreSuccess--Client");
		} catch (DeleteScoreFault e1) {
			System.out.println("deleteScoreError");
			e1.printStackTrace();
		}
		try {
        	System.out.println(itf.searchScore("141250158").get�γ̳ɼ�().size());
        } catch (SearchScoreFault e) {
        	e.printStackTrace();
        }
		�γ̳ɼ����� single2 = new �γ̳ɼ�����();
    	�ɼ����� singlescore2 = new �ɼ�����();
    	singlescore2.setѧ��("141250158");
    	singlescore2.set�÷�(58);
    	single2.set�ɼ�����(�ɼ���������.�����ɼ�);
        single2.set�γ̱��("000001");
        single2.get�ɼ�().add(singlescore2);
        try {
			itf.modifyScore(single2);
			System.out.println("modifyScoreSuccess--Client");
		} catch (ModifyScoreFault e) {
			System.out.println("modifyScoreError");
			e.printStackTrace();
		}
    }  
}
