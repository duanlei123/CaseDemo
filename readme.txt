������Ϊ���Խű���ʾ�����̣�ֱ������bash run.sh�����������й����ڵ����нű���


1. �û��ű�������src\main\java\com\dtdream\productDemoĿ¼��
   productDemo�������޸ĳ�ʵ�ʲ�Ʒ����

2. conf\conf.properties ������Ի���������ñ���
   * ��Ҫ��TestCase���� loadProperties �����ж�ȡ


���� bash makePackage.sh �������������нű���(target Ŀ¼�� tar.gz ѹ����)��
1 �����ѹ��: ���� bash run.sh ����java ִ�в��Խű���
2 ������л�����װ��mvn�������� run_mvn.sh����mvnִ�в��Խű���
   ��java���ж����� TEST-TestSuite.xml �����ļ���


--------------------------------------
�����ļ�Ϊ���ά�����벻Ҫ�޸�
--------------------------------------

1. testng.xml

   ����ִ�нű��Ŀ����ļ�����src�µĲ�Ʒ�����б仯�����Ӧ�޸ġ�
   
   ��������������������Ϊcom.dtdream.paas.testcase����testng��Ӧ�ö�Ӧ�޸ĳɣ�
   com.duanlei.paas.testcase.*