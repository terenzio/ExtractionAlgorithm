package ntu.selab.phrase.suffixtree;

import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.lm.TokenizedLM;
import com.aliasi.util.Files;
import com.aliasi.util.ScoredObject;
import com.aliasi.util.AbstractExternalizable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;

public class Collocation {

    public static int NGRAM = 3;
    public static int MIN_COUNT = 5;
    public static int MAX_NGRAM_REPORTING_LENGTH = 2;
    public static int NGRAM_REPORTING_LENGTH = 2;
    public static int MAX_COUNT = 100;

    public static File BACKGROUND_DIR 
        = new File("data/rec.sport.hockey/train");
    public static File FOREGROUND_DIR 
        = new File("data/rec.sport.hockey/test");

    public static TokenizedLM buildModel(TokenizerFactory tokenizerFactory,
                                          int ngram,
                                          File directory) 
        throws IOException {

        String[] trainingFiles = directory.list();
        TokenizedLM model = 
            new TokenizedLM(tokenizerFactory,
                            ngram);
        System.out.println("Calculating Collcations...");
                    
//        for (int j = 0; j < trainingFiles.length; ++j) {
//            String text = Files.readFromFile(new File(directory,
//                                                      trainingFiles[j]),
//                                                      "ISO-8859-1");
//            System.out.println("TEXT no:"+ j + "text: " + text);
//            model.handle(text);
//        }
        
        File file2 = new File("input3.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file2));
			String line;
				while((line=br.readLine()) != null){
					//sc.scan(line);
					//sc.scanToMix(line, 3);
				//	  System.out.println( "Line: " + line);
					  model.handle(line);
				}
	//	sc.printM();
		br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
        
        
        return model;
    }

    public static void report(SortedSet<ScoredObject<String[]>> nGrams) {
        for (ScoredObject<String[]> nGram : nGrams) {
            double score = nGram.score();
            String[] toks = nGram.getObject();
            report_filter(score,toks);
        }
    }
    
    public static int collocationCount = 0;
    public static void report_filter(double score, String[] toks) {
        String accum = "";
        for (int j=0; j<toks.length; ++j) {
            if (nonCapWord(toks[j])) return;
            accum += " "+toks[j];
        }
        System.out.println("Score: "+score+" with :"+accum);
        PhraseSuffix_Tree.collocationStrings[collocationCount] = accum;
        collocationCount++;
    }

    public static boolean nonCapWord(String tok) {
        if (!Character.isUpperCase(tok.charAt(0)))
            return true;
        for (int i = 1; i < tok.length(); ++i) 
            if (!Character.isLowerCase(tok.charAt(i))) 
                return true;
        return false;
    }

}
