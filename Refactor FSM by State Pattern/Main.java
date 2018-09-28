/*
	 1.有限状态机：地铁十字旋转门是一个简单的有限状态机-FSM
	 2.它有两种表述方式：
		 ①STD-状态迁移图
			 四部分组成：状态(圆形)，迁移(连接状态的箭头)，事件名/动作名(箭头上的标注)
		 ②STT-状态迁移表	
			 四部分组成：起始状态，触发事件，终止状态，要执行的动作
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 嵌套switch/case
			 优点：适用于简单的FSM，所有状态和事件都在一起出现
			 缺点：不适合复杂FSM，所有状态机的逻辑状态和实现动作的代码之间没有很好的分离
				 (下面的程序使用controller分离了)，但大多数会写在switch/case中
		 */
		 TurnStileController controller = new TurnStileControllerImp();
		 TurnStile ts = new TurnStile(controller);
		 ts.event(ts.COIN);
		 /*
			 状态迁移表-创建一个描述状态迁移的数据表，该表被一个处理事件的引擎解释，引擎查找与事件匹配的迁移，
			 调用相应的动作，并改变状态
			 优点：状态机的逻辑全部集中在一起且未被动作的实现污染。要增加新的迁移，只需向TurnStileSTT的构造函数
				 中增加一行addtransition。②迁移表可在运行时动态改变，即允许动态改变状态机的逻辑。③可创建多个迁移表，
				 每个都代表一个不同的状态机逻辑，这些表可以根据启动条件动态选择。
			 缺点：慢
			 
		 */
		 TurnStileSTT stt = new TurnStileSTT(controller);
		 stt.event(stt.PASS);
		 /*
			 状态模式
			 彻底分离了状态机的逻辑和动作，动作实在context中实现。而逻辑是分布在state类的子类中，这使二者可以独立变化，
			 使用一个新的state子类，就可以创建一个不同的状态逻辑并且重用context类的动作。相反，也可以在不影响state子类
			 逻辑下创建context子类来更改或替换动作实现
		 */
		 TurnStileContext context = new TurnStileContext(controller);
		 context.pass();
	 }
}