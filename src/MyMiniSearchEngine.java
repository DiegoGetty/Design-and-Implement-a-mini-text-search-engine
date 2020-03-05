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

    private void index(List<String> texts) {

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
                    indexes.put(words[j].toLowerCase(), arr);
                }
                indexes.get(words[j]).get(i).add(j);
            }

        }
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.

    public List<Integer> search(String keyPhrase) {

        List<Integer> answer = new ArrayList<>();
        if(keyPhrase==null){
            return answer;
        }

        String[] words= keyPhrase.split(" ");
        List<List<Integer>> result = indexes.get(words[0].toLowerCase());

        for(int i = 1; i < words.length; i++) {
            List<List<Integer>> temp = indexes.get(words[i].toLowerCase());

            if(temp == null) {
                return new ArrayList<>();
            }

            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).isEmpty()) {
                    temp.get(j).clear();
                }
                else {
                    for (int k = 0; k < temp.get(j).size(); k++) {
                        int l = 0;
                        while (result.get(j).get(l) < temp.get(j).get(k)) {
                            l++;
                            if(l>=result.get(j).size())
                                break;
                        }

                        if(l > 0){
                            --l;
                        }

                        if (result.get(j).get(l) != (temp.get(j).get(k) - 1)) {
                            temp.get(j).remove(k);
                            k--;
                        }
                    }
                }
            }
            result = temp;
        }

        for(int i = 0; i < result.size(); i++){
            if(!result.get(i).isEmpty()){
                answer.add(i);
            }
        }
        return answer;
    }
}
