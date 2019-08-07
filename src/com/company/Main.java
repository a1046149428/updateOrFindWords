package com.company;

import java.io.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        File f = new File("C:\\Users\\cherb\\Desktop\\111");
        Main updateFile = new Main();
        updateFile.update(f);
    }

    public void update(File f) throws FileNotFoundException, IOException
    {
        if (f.isFile())
        {
            updateFile(f);
        } else
        {
            File[] files = f.listFiles();
            for (File file : files)
            {
                update(file);
            }
        }
    }


    public void findWords(File f) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while ((line = br.readLine()) != null)
        {
            if (line.contains("xxx"))
            {
                System.out.println(f.getAbsolutePath());

            }
        }
    }

    public void updateFile(File f) throws FileNotFoundException, IOException
    {

        File f2 = new File(f.getAbsolutePath() + "2");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {

            br = new BufferedReader(new FileReader(f));
            bw = new BufferedWriter(new FileWriter(f2));

            String line = null;
            while ((line = br.readLine()) != null)
            {
                String newLine = line;
                if (line.contains("xxx"))
                {
                    System.out.println(f.getAbsolutePath());
                    newLine = "";

                }


                bw.write(newLine);
                bw.newLine();
            }
            bw.flush();
        } finally
        {
            if (bw != null)
            {
                bw.close();
            }
            if (br != null)
            {
                br.close();
            }
            /*boolean isDelete = */
            f.delete();
            String f2Name = f2.getName();
//			System.out.println(f2Name);
//			System.out.println(isDelete);
            f2.renameTo(f);

            System.out.println("更新完成文件：" + f.getAbsolutePath());
        }
    }

}
