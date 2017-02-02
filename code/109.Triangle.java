public int minimumTotal(int[][] triangle) {
        int ans = 0;
        int bottom = triangle.length;
        int[] temp = triangle[bottom - 1];
        for(int i = bottom - 2; i >= 0; i--){
        	for(int j = 0; j < triangle[i].length; j++){
        		temp[j] = Math.min(temp[j + 1], temp[j]) + triangle[i][j];
        	}
        }
		return temp[0];
    }