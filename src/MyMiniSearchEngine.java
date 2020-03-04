import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.

    /*

     */

    private void index(List<String> texts) {
        //homework
        System.out.println(texts);
        indexes = new HashMap<>();

        //parse strings from texts
        for (int i = 0 ; i< texts.size(); i++){

            String[] words = texts.get(i).split(" ");

            //add word -> document + location
            for (int j = 0; j < words.length; j++){

                if (!indexes.containsKey(words[j])){
                    List<List<Integer>> arr = new ArrayList<>();
                    for (int k = 0 ; k< texts.size(); k++){
                        arr.add(new ArrayList<Integer>());
                    }
                    indexes.put(words[j], arr);
                }


                indexes.get(words[j]).get(i).add(j);

            }
        }

        System.out.println(indexes);

    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.

    /*

     */
    public List<Integer> search(String keyPhrase) {
        // homework






        
        return new ArrayList<>(); // place holder
    }
}
