��ҳ��ܣ�
       MyPager
       ��ҳ���Ӽ򵥣����ǾͲ���Ҫ����Աдһ�д��룬�ͺܺ�ʵ�ַ�ҳЧ��
       
����:
   ����Ա
   class UserDao{
        @Pager
       public List<User> findAll(){}
       }
    ����ܹ��Զ���ҳ
     ��ע��AOP :д��ע��������ʵ��������
     Ŀ��:�����ó���Աֻ��ע�Լ��ù�ע������,�����ҳ�Ļ��ͼӼ����򵥱�ע����
              �̳߳�
 2.MiniPager���
    100Ԫ���������(��ۣ�����)
    MiniPager
    Jquery.js Vue.js
   Ŀ��:
   (1)   ʹ�ñ�ע��ʵ�ַ�ҳ
    (2)   ��ų���Ա��д�ظ��ķ�ҳ����
     (3)   ����Dao����
     ʵ�֣�
     ����:�Խ��Ϊ����ȥ�����������Գ���Ա����������
      UserDao
           List<User>findAll();
           @MiniPager(tableName="t_user")
           List<User>findPaged(int offset,int pageSize){
                      return jdbcTemplate.query(
                      "select * from user limit ?,?"
                      new Object[]{offset,pageSize});
                      }
                      
     ��д����:
     (1).     ��д�Զ����ע
              @MiniPager  :����Ӧ���и���������
     (2).    ��д����:(���Ŀ�ܴ���)
             a.  ������������AoP�Ĺ���
                  @EnableAdpectJAutoProxy
                  @ComponentScan({"dao","service","util"})
             b.��д�Զ�������
                util:  PagerAspect(��ҳ����)
                 @Aspect
                 @Component
                 class PagerAspect{}
              c.  �Զ��������е��е㣺
              //--���service�����Ӱ��µ����з���
                   @Pointcut("execution(* service..*(..))")    //--���service�����Ӱ��µ����з���
	                 public void selfPointcut() {}               
               d.�Զ���֪ͨ(AroundAdvice)
                  @Around("selfPointcut()")
	         public List aroundAdvice(ProceedingJoinPoint jp) {
		       public List aroundAdvice(ProceedingJoinPoint jp) {
	        	System.out.println("hello pager");
		    try {
			      jp.proceed();
		       } catch (Throwable e) {
			    // TODO Auto-generated catch block
			        e.printStackTrace();
		        }
		        return null;
		
	           }
		           ����:ֻҪ�ǵ���service���µ���ķ�������Ӧ�����hello pager��仰
		      e.��д֪ͨ������ĺ��Ĵ���(ʵ��ͨ�÷�ҳ�ĺ��Ĵ���) 
		        1.ֻ���ڼ�����@MinPager��ע�ķ�����ʵ�����ع���  
	                                       ˼·��
	              �õ������õķ�������Method����Ȼ���жϸ÷�������û��@MiniPager��ע
	            ���оͼ������湦�ܣ����򲻼�
	            ii.����Ϳ���ʵ�������ķ�ҳ�߼�
       
       
       
       
       
       
      
      
      