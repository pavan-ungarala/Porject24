package com.infy.medium;

import java.util.Arrays;

/*
Jumping on the clouds, where some of the clouds are thunder heads and others are cumulu's. A player can jump
one/two clouds from the current cloud by avoiding the jump on thunderhead's. Find the minimum number of jumps
from the first cloud to end cloud. In array: 1: thunder head and 0: cumulu's. Example: arr={0,1,0,0,0,1,0}
Two paths are possible 0->2->4->6 and 0->2->3->4->6
       Answer : 3 (minimum jumps)
   Exceptional cases: 
   # 0th and 1st index should not be 1's
   # last index should not be 1
 */
public class CloudJumping {
	
	public static int minimumJumps(int[] arr) {
		int length = arr.length;
		int count = 0;
		int i=1;
		int j = 1;
		while(i < length) {
			if(arr[i] == 0 ) {
				if(arr[i+1] == 0) {
					count++;
					i +=2;
					continue;
				}
				count++;
			}else if(arr[i+1] == 0) {
				i++;
				count++;
			}else {
				count = 0;
				System.out.println("two thunders continusly");
				break;
			}
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] input = {0,1,0,0,0,1,0};
		int length = input.length;
		if(input != null && length < 2 && (input[0] ==1 || input[1] ==1) && input[length-1] == 1) {
			System.out.println("Jump not possible "+ 0);
		}
		int jumps = minimumJumps(input);
		System.out.println("Minimum jumps are: "+jumps);
	}

}
