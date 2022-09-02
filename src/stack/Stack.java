
class Stack {
	int[] stack;
	int pointer = 0;
	
	Stack(){
		stack = new int[4];
	}
	
	int pop(){
		if(pointer < (stack.length/2 - 1)) {
			int[] newStack = new int[(stack.length / 2)];
			for(int i=0;i<stack.length/2;i++) {
				newStack[i] = stack[i];
			}
		stack = newStack;
		}
		return stack[pointer--];
		
		
	}
	
	void push(int i){
		if(pointer == stack.length) {
			int[] newStack = new int[stack.length * 2];
			for(i=0;i<stack.length;i++) {
				newStack[i] = stack[i];
			}	
		stack = newStack;
		}
		
		stack[++pointer] = i;
		
	}
	
}
