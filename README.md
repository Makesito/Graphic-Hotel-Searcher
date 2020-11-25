**Welcome to the new version of the ultimate Hotel searcher.**

# Basic Guide

This time we are trying to make a more intuitive and accesable programm at the user and developer level.
The final object is to be able to change every setting and have total control of the programm through graphic menu's.

For now the prime realised objectives have bean:
    **1.** Total acces to the data with txt files.
    **2.** Basic Graphic Menu
    **3.** Optimice basic methods
    
# TXT editing guide
  Every txt whill be generated with the internal methods but you can also make then the hard way through your file explorer.
  
  **Hotel method**
  
    name "hotel name" 
    
    distance float_with_the_distance_to_the_center_of_the_city
    
    pool boolean(string "true" or "false")
    
    city "city name"
    
    wifi boolean(string "true" or "false")
    
  **Restaurant method**
  
    name "restaurant name" 
    
    distance float_with_the_distance_to_the_center_of_the_city
    
    michelib boolean(string "true" or "false")
    
    city "city name"
    
  **Description**
    
    The whole txt file assign the description String
    
  **Room method**
  
  // The room method can be exucuted with a previous hotel methos or not, any of the ways it will create all the necessary data.
    
    name "room name"
    
    price float
    
    smoke boolean(string "true" and "false")
    
    capability int_number_of_persons
    
  **busy**
    
    save all the busy dates of a room with the LocalDate sintaxs yyyy-mm-dd
    
  **comments**
    
    array of int numbers with the values of the guest reviews
    
  **Class Graph**
  
  <object data="https://github.com/Makesito/Graphic-Hotel-Searcher/blob/master/DiagramaGraphicHotel.pdf" type="application/pdf" width="700px" height="700px">
    <embed src="hhttps://github.com/Makesito/Graphic-Hotel-Searcher/blob/master/DiagramaGraphicHotel.pdf">
        <p>This browser does not support PDFs. Please download the PDF to view it: <a href="https://github.com/Makesito/Graphic-Hotel-Searcher/blob/master/DiagramaGraphicHotel.pdf">Download PDF</a>.</p>
    </embed>
</object>
    
    
  **Last Updates**
  
      Now the main reusable methods has bean implemented as interfaces for future reutilization with easier understanding.
      Maybe this is not such a big change in the final result of the code, but it will ease the work of external coders and
      the faster reading understanding of the       code.
      That way the inclusion of new workers to the project will a fast and simple task to the new and old programmers working on it.
      
      Talking about more visual and intuitive update, the whole graphical interface has bean translate into english with the posibility
      as many new lenguages as you       want without modifying any code except the new translations. The implementation of direct google
      translation has bean consider as posible new method on the international string implemtation.
      
      
  **Data followed for the develop process**
  
  
      https://www.javatpoint.com/java-swing
      
  **Follow us**
  
  
      https://twitter.com/soyaquelfriki
