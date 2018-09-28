/*
	 1.������������װ��һ�������У���������������κ�ִ����������ηֿ������󷽺�ִ�з������ݻ������󷽲���֪��ִ�з��ӿ�(ͨ��Command����)
	 2.awt�У��������ʵ��awt��Listener�ӿڣ�awt�����൱��Invoker
	 3.MacroCommand�̳�Command�ӿڲ�����add��remove������������������ɾ���������executeѭ��ִ��commandList�д洢������
	 4.ʹ�ó��ϣ�
		 ��һ����������ԭ�ȵ����󷢳����в�ͬ���������ڡ���������߿��Բ��ٱ��أ��������ͨ�����л�����
		 ��ϵͳ��Ҫ֧������ĳ���(undo)
		 ��ϵͳ�����ݸ��µ���־������ʱ�������е��������µ���execute���ָ�����ǰ��������
		 ��һ��ϵͳ��Ҫ֧�ֽ��ף����׽ṹ��װһ������������ģʽ���������µ�����
	 5.JDK�е�Runnableʵ�ִ�ģʽ
*/
public class Main {
	 public static void main(String[] args) {
		 Receiver recv = new Receiver();	
		 Command cmd = new ConcreteCommand(recv);
		 Command cmd1 = new ConcreteCommand1(recv);
		 Invoker invoker = new Invoker(cmd, cmd1);
		 invoker.action();
		 invoker.action1();
		 
		 MacroCommand mc = new ConcreteMacroCommand();
		 mc.add(cmd);
		 mc.add(cmd1);
		 mc.execute();
		 
		 
		 Undoable unCmd = new CommandWithUndo(recv);
		 unCmd.execute();
		 unCmd.undo();
		 unCmd.redo();
	 }
}

// ��һ������ģʽ
public interface Command {
	public String execute();
	public void putValue(String key, Object value);
	public Object getValue(String key);
}

public class AllFileCommand implements Command {
	private CommandHandler handler;
	private Map<String, Object> args = new HashMap<String, Object>();
	
	public AllFileCommand(CommandHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public String execute() {
		
		return handler.doAllOption(args.get("str"), (File)args.get("f"))
	}

	@Override
	public void putValue(String key, Object value) {
		args.put(key, value);
	}


	@Override
	public Object getValue(String key) {
		return args.get(key);
	}

}

public class CommandHandler {
	public String doAllOption(String str, File f, ...) {
		...
		return "";
	}
	
}
// ����
main () {
	CommandHandler handler = new CommandHandler();
	Command pathCommand = new AllFileCommand(handler);
	pathCommand.putValue("f", cksumDBFile);
	pathCommand.execute();
}
