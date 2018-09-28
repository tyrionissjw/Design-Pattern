/*
	 1.把请求或操作封装到一个对象中，将请求命令的责任和执行命令的责任分开。请求方和执行方独立演化，请求方不必知道执行方接口(通过Command关联)
	 2.awt中，命令对象实现awt的Listener接口，awt构件相当于Invoker
	 3.MacroCommand继承Command接口并加入add和remove方法，用以添加命令和删除命令，它的execute循环执行commandList中存储的命令
	 4.使用场合：
		 ①一个命令对象和原先的请求发出者有不同的生命周期。命令接受者可以不再本地，命令对象通过序列化传送
		 ②系统需要支持命令的撤销(undo)
		 ③系统将数据更新到日志，崩溃时读回所有的数据重新调用execute，恢复崩溃前所做更新
		 ④一个系统需要支持交易，交易结构封装一组更新命令，命令模式易于增加新的命令
	 5.JDK中的Runnable实现此模式
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

// 另一种命令模式
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
// 调用
main () {
	CommandHandler handler = new CommandHandler();
	Command pathCommand = new AllFileCommand(handler);
	pathCommand.putValue("f", cksumDBFile);
	pathCommand.execute();
}
