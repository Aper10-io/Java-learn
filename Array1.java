
// practice array list 1
// type 1
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Hello Welcome to Java Programming");
// int array1[]={7,7,6,6,5,5,4,4};
// for(int i=0;i<8;i=i+2)
//  System.out.print(array1[i]);
// System.out.println();
//     }
// }
// # output nya bakal mengeluarkan Hello Welcome to Java Programming

// practice array list type 2
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Array Type 2");
// int array[][] = {{2,3,1,2},{2,1,0,2},{3,1,0,4}};
// for(int i=0;i<3;i++)
// {
//  for(int j=0;j<4;j++)
// System.out.print(array[i][j] + " ");
// }
// System.out.println();

// }
//     }

// # output nya bakal mengeluarkan Array Type 2
//2 3 1 2
//2 1 0 2
//3 1 0 4

// practice array list type 3
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Array Type 3");
//         {
//             int array3[][] = {{2,3,1},{2,1,2}};
//             for(int i=0;i<2;i++)
//                 for(int j=0;j<3;j++)
//                     if(array3[i][j]==2&&j==2)
//                     System.out.print(array3[i][j] + " ");
//         System.out.println();

//         }
//     }
// }
// # output nya bakal mengeluarkan Array Type 3
//2 2
// # karena yang di print hanya angka 2 yang berada di kolom ke 3 (j==2)
// # jadi yang muncul hanya 2 angka 2 saja

// practice array list type 4
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Array Type 4");
//         {
//             int array4[][] = new int[1][2];
//                 for(int i=0;i<1;i++)
//                     for(int j=1;j<2;j++)
//                     {
//                         array4[i][j]=i+4*j;
//                 System.out.print(array4[i][j] + " ");
//                     }
//         System.out.println();
//         }
//     }
// }
// # output nya bakal mengeluarkan Array Type 4
//0 4
// # karena rumusnya adalah i+4j jadi untuk setiap i dan j akan di kalkulasi sesuai rumus tersebut
// # namun karena i hanya 0 dan j hanya 0 dan 1 maka yang muncul hanya 0 dan 4 saja
// untuk i=0,j=0 -> 0+4*0=0

// practice array list type 5
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Array Type 5");
//         {
//             int array5[]={6,5,5,4,4,3};
//             int array6[]={1,9,6,7,1,3};
//                 for(int i=0;i<6;i++)
//             System.out.println(array5[i] + array6[i]);
//         }
//     }
// }
// # output nya bakal mengeluarkan Array Type 5
//7
//14
//11
//11
//5
//6
// # karena setiap index dari array5 dan array6 di jumlahkan
// # jadi 6+1=7

// practice array list type 6
// public class Array1 {
//     public static void main(String[] args) {
//         System.out.println("Array Type 6");
//             int array7[][]={{3,3,3},{2,2,2}};
//                 for(int i=0;i<3;i++)
//                     array7[1][i]=4;
//                 for(int i=0;i<2;i++)
//                 {
//             for(int j=0;j<3;j++)
//                 System.out.print(array7[i][j]);
//             System.out.println();
//                 }
//         }
//     }
// }
// # output nya bakal mengeluarkan Array Type 6
//333
//444
// # karena pada baris ke 2 (index 1) semua elemennya di ganti dengan angka 4

// practice array list type 7
public class Array1 {
    public static void main(String[] args) {
        System.out.println("Array Type 7");
            int array8[][]={{3,3,3},{2,2,2}};
            int array9[][]={{1,1,1}};
            for(int i=0;i<3;i++)
                array8[1][i]=array8[0][i]+array9[i];
                // array8[1][0]=array8[1][0]+array9[0][i]; > ini yang benar
            for(int i=0;i<2;i++)
            {
        for(int j=0;j<3;j++)
            System.out.print(array8[i][j]);
        System.out.println();
            }
    }
}
// # output nya bakal mengeluarkan Array Type 7
// dia bakalan eror logic karena pada bagian array8[1][i]=array8[i]+array9[i];
// # karena array8 dan array9 adalah array 2 dimensi sedangkan array8[i] dan array9[i] adalah array 1 dimensi
// # jadi tidak bisa di jumlahkan begitu saja harus di akses elemennya satu persatu
// # jadi harusnya di tulis seperti ini array8[1][i]=array8[1][i]+array9[0][i];
// # maka outputnya akan menjadi seperti ini
// Array Type 7