   public boolean checkOutOfBound(int currentPosition, int maxRange){
        return (currentPosition >= 0 && currentPosition < maxRange);
    }
    public boolean checkValid(int currRow, int currCol, int maxRow, int maxCol){
        return checkOutOfBound(currRow, maxRow) && checkOutOfBound(currCol, maxCol);
    }
    public void floodFillTemp(char[][] map, int vertical, int horizontal){
        if (checkValid(vertical, horizontal, map.length, map[0].length)){
            if (map[vertical][horizontal] == '1'){
                map[vertical][horizontal] = 'x';
                floodFillTemp(map, vertical, horizontal + 1);
                floodFillTemp(map, vertical - 1, horizontal);
                floodFillTemp(map, vertical, horizontal - 1);
                floodFillTemp(map, vertical + 1, horizontal);
            } else if (map[vertical][horizontal] == 'x' || map[vertical][horizontal] == '0'){
                return;
            }
        }
    }
    public int getNumberOfIsland(char[][] map){
        int islandCount = 0;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
               // System.out.println(j);
                if (checkValid(i, j, map.length, map[i].length) && map[i][j] != 'x' && map[i][j] != '0'){
                    floodFillTemp(map, i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
