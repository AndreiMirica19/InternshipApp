package com.example.internshipsignincontractapp.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbConnector {
    public FirebaseFirestore db ;
    public DatabaseReference students;
    public CollectionReference collectionReference;
    public List<Students> studentList = new ArrayList<>();
    public Students currentUser;
    private static DbConnector dbConnector;
    private DbConnector() {

       db= FirebaseFirestore.getInstance();
       collectionReference=db.collection("Students");
       collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
               if (task.isSuccessful()) {
                   
                   for (QueryDocumentSnapshot document : task.getResult()) {
                      Students s = new Students(document.getString("name"),document.getString("password"),document.getString("email"));
                      s.setId(document.getId());
                      if (document.getString("group")!= null)
                          s.setGroup(document.getString("group"));
                       studentList.add(s);
                   }

               } else {
                   Log.d("TAG1", "Error getting documents: ");
               }
           }
       });;



    }
    public void addUser(Students user, String accountType){

        HashMap <String,String>userMap = new HashMap();
        userMap.put("name",user.name);
        userMap.put("password",user.password);
        userMap.put("email",user.email);
        currentUser = user;
        db.collection(accountType+"s").add(userMap);
    }
    public void updateStudent(String name,String group){
        db.collection("Students").document(currentUser.id).update("name",name);
        db.collection("Students").document(currentUser.id).update("group",group);
    }

    public Boolean credentialsValidator(String username,String password){
        for( Students u :studentList) {
            if (username.equals(u.getName()) && password.equals(u.getPassword())) {
                currentUser = u;
               return  true;
            }
        }
        return false;
    }
    public static DbConnector getInstance(){
        if (dbConnector == null){
            dbConnector = new DbConnector();

        }
        return dbConnector;
    }

}
