package utils.validate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultUtils {

    private int success, update, failure, dataError, sqlError;

    public ResultUtils(int resultVariable) {
        resultCheck(resultVariable);
    }

    public void resultCheck(int result){
        switch (result){
            case -3:
                sqlError++;
                break;
            case -2:
                dataError++;
                break;
            case 0:
                failure++;
                break;
            case 1:
                success++;
                break;
            case 2:
                update++;
                break;
        }
    }
    public void resultReport(){
        if (update != 0 && success == 0 && failure == 0 && dataError == 0 && sqlError == 0) {
            System.out.printf("Update %d record successfully!\n", update);
        } else {
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
}
