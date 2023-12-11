package utils.validate;

public class ResultUtils {
    private static int success = 0, update = 0, failure = 0, dataError = 0, sqlError = 0;
    public static void resultCheck(int result){
        if (result == 2){
            update++;
        }
        if (result == 1){
            success++;
        }
        if (result == 0){
            failure++;
        }
        if (result == -2){
            dataError++;
        }
        if (result == -3){
            sqlError++;
        }
    }
    public static void resultReport(){
        if (success != 0){
            System.out.printf("Insert %d record successfully!\n", success);
        }
        if (update != 0){
            System.out.printf("Update %d record successfully!\n", update);
        }
        if (failure != 0){
            System.out.printf("Insert %d record failed!\n", failure);
        }
        if (dataError != 0){
            System.out.printf("%d record have error data!\n", dataError);
        }
        if (sqlError != 0){
            System.out.printf("%d record have sql error!\n", sqlError);
        }
    }
}
