package service;

import xmlSource.XMLSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/Translate/{original}/{originalLanguage}/{outputLanguage}")
public class Translate {

   @GET
  //  @Path("{original}/{originalLanguage}/{outputLanguage}")
    @Produces("text/plain")
    public String getText(@PathParam("original") String original,
            @PathParam("originalLanguage") String originalLanguage,
            @PathParam("outputLanguage") String outputLanguage) throws Exception {
                 

        XMLSource dataLSource = new XMLSource();
        String translatedWord = dataLSource.getTranslation(original, originalLanguage, outputLanguage);
        
        if(translatedWord == null || translatedWord.isEmpty())
            return "Translation does not exist";
        
        return translatedWord;
    }
}
