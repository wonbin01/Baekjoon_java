import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

//고속도로에서 나간 차량이 다시 진입하는 경우 구현
//인덱스 처리

public class hcms_202126845 
{
    public static time current = new time();
    public static Carinfo[] Cararray = new Carinfo[100]; // 자동차에 대한 배열을 정의//
    public static String[] location = new String[5]; // 가능한 지역 초기화 과정//
    public static int[] distance = new int[5]; // 서울로부터의 거리 초기화
    public static Carinfo[] departcar=new Carinfo[100];// 진입한 차량의 정보 저장하는 배열
    public static int departnumber = 0; //바깥을 보내면 계속 출력이 가능해지므로 조건 고려
    public static void main(String[] args) throws Exception 
    {
        Scanner scanner = new Scanner(System.in);
        String cmd; // 명령어를 입력받는 문자 변수 선언
        char firstChar;
        current.year = 2024; // 초기 시간 정하는 과정//
        current.month = 3;
        current.date = 20;
        current.hour = 21;
        current.minute = 0;
        int gap=0;
        int carindex = 0;
        location[0] = "서울";
        location[1] = "수원";
        location[2] = "대전";
        location[3] = "대구";
        location[4] = "부산";
        distance[0] = 0; // 서울
        distance[1] = 30; // 수원
        distance[2] = 130; // 대전
        distance[3] = 290; // 대구
        distance[4] = 400; // 부산
        while (scanner.hasNextLine()) // 다음줄이 존재하면 실행 아니면 실행종료//
        {
            cmd = scanner.nextLine(); // cmd에서 문자를 읽어드림
            firstChar = cmd.charAt(0); // 첫번째 문자열을 받아드림
            String[] tokens = cmd.split("\\s+"); // 공백을 기준으로 나눔//

            if (firstChar == 't') // 시간 설정
            {
                time Time = new time(); // 새로운 변수 선언
                settime(Time, tokens); // 새로운 시간 설정
                boolean check=checktime(Time); // 유효한 시간인지 확인하는 과정
                if(check)
                {
                    gap=calculateTimeGap(current, Time); // 설정한 시간과 그 이전의 시간의 간격을 계산하는 과정
                if(gap<=0)
                {
                    System.out.println("잘못된 시간입니다.");
                    Time=current;
                }
                else 
                {
                    current.year = Time.year; // 입력한 시간을 현재 시간으로 업데이트하는 과정//
                    current.month=Time.month;
                    current.date=Time.date;
                    current.hour=Time.hour;
                    current.minute=Time.minute; //
                }
            }
            } 
            else if (firstChar == 'n') // 차량 진입
            {
                int carNumber = Integer.parseInt(tokens[1]);
                String start = tokens[2];
                String end = tokens[3];
                Carinfo newCar = new Carinfo();
                newCar.carnumber = carNumber;
                newCar.start = start;
                newCar.end = end;
                if(checkcarnumber(newCar)) // 차량의 번호를 확인하는 메서드->적절하다면 다음 과정 진행
                {
                if(checkhighway(newCar, Cararray, carindex)) //고속도로에 있는지 확인하는 메서드->없으면 다음 과정 진행
                {
                    initializeEntrance(newCar, current); //진입시간 초기화
                    initializeDeparture(newCar); // departure 필드 초기화
                    initializehalftime(newCar, current); //halftume 필드 초기화
                    if(checklocation(newCar, location)) // 적절한 지역인지 확인하는 과정->적절하다면 다음 과정 진행
                    {
                        int distance=calculatedepart(newCar);
                        endtime(distance,newCar);
                        Cararray[carindex] = newCar; // 차량 업데이트
                        carindex++;
                    }
                }
                }
            }

            else if (firstChar == 'o') // 고속도로의 모든 차량 보기
            {
                System.out.printf("현재시간:%d/%02d/%02d-%02d:%02d\n", current.year, current.month, current.date,
                        current.hour, current.minute);
                printCarInfo(Cararray,carindex);
            } 
            else if (firstChar == 'x')// 진출한 차량의 정보 출력
            {
                System.out.printf("현재시간:%d/%02d/%02d-%02d:%02d\n", current.year, current.month, current.date,
                        current.hour, current.minute);
                        printdeparture(Cararray, carindex); //
            } 
            else if (firstChar == 'q') 
            {
                System.out.println("프로그램을 종료합니다.");
                System.exit(-1);
            } else 
            {
                System.out.println("잘못된 입력입니다."); //
            }
        }
        scanner.close();
    }
    public static class time 
    {
        int year;
        int month;
        int date;
        int hour;
        int minute;
    }

    public static void settime(time Time, String[] tokens) 
    {
        Time.year = Integer.parseInt((tokens[1]));
        Time.month = Integer.parseInt((tokens[2]));
        Time.date = Integer.parseInt((tokens[3]));
        Time.hour = Integer.parseInt((tokens[4]));
        Time.minute = Integer.parseInt((tokens[5]));
    }

    public static int calculateTimeGap(time current, time newTime) 
    {
        LocalDateTime currenttime=LocalDateTime.of(current.year,current.month,current.date,current.hour,current.minute);
        LocalDateTime newtime=LocalDateTime.of(newTime.year,newTime.month,newTime.date,newTime.hour,newTime.minute);
        long minutediefference=ChronoUnit.MINUTES.between(currenttime,newtime);
        return (int) minutediefference;
    }

    public static boolean checktime(time Time) // 입력된 시간의 유효성을 판단하는 method//
{
    if (Time.year < 0 || Time.month <= 0 || Time.month > 12) 
    {
        System.out.println("잘못된 시간입니다.");
        Time.year = current.year;
        Time.month = current.month;
        Time.date = current.date;
        Time.hour = current.hour;
        Time.minute = current.minute;
        return false;
    }

    switch (Time.month) 
    {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (Time.date <= 0 || Time.date >= 32)
            {
                System.out.println("잘못된 시간입니다.");
                Time.year = current.year;
                Time.month = current.month;
                Time.date = current.date;
                Time.hour = current.hour;
                Time.minute = current.minute;
                return false;
            }
            break;
            
        case 4:
        case 6:
        case 9:
        case 11:
            if (Time.date <= 0 || Time.date >= 31)
            {
                System.out.println("잘못된 시간입니다.");
                Time.year = current.year;
                Time.month = current.month;
                Time.date = current.date;
                Time.hour = current.hour;
                Time.minute = current.minute;
                return false;
            }
            break;

        case 2:
            boolean isLeapYear = (Time.year % 4 == 0 && Time.year % 100 != 0) || (Time.year % 400 == 0);
            if (isLeapYear)
            {
                if (Time.date > 29 || Time.date <= 0)
                {
                    System.out.println("잘못된 시간입니다.");
                    Time.year = current.year;
                    Time.month = current.month;
                    Time.date = current.date;
                    Time.hour = current.hour;
                    Time.minute = current.minute;
                    return false;
                }
            }
            else
            {
                if (Time.date > 28 || Time.date <= 0)
                {
                    System.out.println("잘못된 시간입니다.");
                    Time.year = current.year;
                    Time.month = current.month;
                    Time.date = current.date;
                    Time.hour = current.hour;
                    Time.minute = current.minute;
                    return false;
                }
            }
            break;
    }

    if (Time.hour < 0 || Time.hour > 23 || Time.minute < 0 || Time.minute > 59)
    {
        System.out.println("잘못된 시간입니다.");
        Time.year = current.year;
        Time.month = current.month;
        Time.date = current.date;
        Time.hour = current.hour;
        Time.minute = current.minute;
        return false;
    }
    
    return true; // 유효한 시간이면 true 반환
}


    public static boolean checkcarnumber(Carinfo newCar) 
    {
        try {
            File file = new File("hcms.txt");
            Scanner scanner = new Scanner(file);
            // 파일을 모두 읽고 나서 스캐너를 닫기 위해 while 루프 외부에 위치시킵니다.
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                int Carnumber = Integer.parseInt(tokens[0]);
                if (Carnumber == newCar.carnumber) 
                {
                    newCar.carcc = Integer.parseInt(tokens[1]);
                    newCar.carspeed = Integer.parseInt(tokens[2]);
                    scanner.close(); // 파일을 모두 읽은 후에 스캐너를 닫습니다.
                    return true;
                }
            }
            // 파일을 모두 읽고 나서 스캐너를 닫기 위해 while 루프 외부에 위치시킵니다.
            scanner.close();
            System.out.println("적절하지 않은 차량번호입니다.");
            return false;
        } catch (FileNotFoundException e) {
            System.out.printf("파일을 찾을 수 없습니다.");
            System.exit(-1);
            return false;
        }
    }
    
    public static boolean checkhighway(Carinfo newCar, Carinfo[] Cararray, int carindex) // 고속도로에 이미 존재하는 지 확인하는 메서드
    {
        for (int i = 0; i < carindex; i++) 
        {
            if (newCar.carnumber == Cararray[i].carnumber&&newCar.entrance==Cararray[i].entrance) 
            {
                System.out.println("고속도로에 이미 있는 차량입니다."); 
                return false;
            }
        }
        return true;
    }

    public static boolean checklocation(Carinfo newCar, String[] location) // 알맞은 지역인지 확인하는 메서드
    {
        int checkpoint = 0;
        for (int i = 0; i < 5; i++) 
        {
            if (((newCar.start.equals(location[i])) || (newCar.end.equals(location[i])))&&!newCar.start.equals(newCar.end)) 
            {
                checkpoint++;
            }
        }
        if (checkpoint != 2) 
        {
            System.out.println("적절하지 않은 지역입니다.");
            return false;
        }
        else //적절한 지역을 입력받았을 때
        {
            for(int i=0;i<5;i++)
            {
                if(newCar.start.equals(location[i]))
                {
                    newCar.start=location[i];
                }
                if(newCar.end.equals(location[i]))
                {
                    newCar.end=location[i];
                }
            }
            return true;
        }
    }
    public static void printCarInfo(Carinfo[] carArray,int carindex) // 차량의 정보를 출력하는 메서드
    {
        boolean printinfo=false;
        if (carindex== 0) 
        {
            System.out.println("고속도로에 차가 존재하지 않습니다.");
            return;
        }
        int deleteindex=-1; //삭제할 차량의 인덱스
        int printnumber=1; //출력한 차량 번호
        for(int i=0;i<carindex;i++)
        {
            int distance = calculatedepart(carArray[i]); // 두 지역 사이의 거리를 의미
            carArray[i].distance=calculatelocation(carArray[i])+carArray[i].distance; //차량이 진입 시간부터 이동한 거리를 의미
            if(distance<=Math.abs(carArray[i].distance))
            {
                deleteindex=i; //삭제할 인덱스 찾음
                departcar[departnumber]=carArray[i]; //삭제할 차량정보를 departcar에 저장
                departcar[departnumber].price=calculateprice(departcar[departnumber]); //
                departnumber++; //배열에 저장했으므로 변수 크기 증가
                break;
            }
        }
        if(deleteindex!=-1) //삭제할 인덱스를 찾은 경우
        {
            for (int i = deleteindex; i < carindex - 1; i++) 
            {
                // 삭제할 요소 이후의 모든 요소를 한 칸씩 앞으로 당깁니다.
                carArray[i] = carArray[i + 1];
            }
            carindex--;
        }
        for (int i = 0; i < carindex; i++) 
        {
            int distance = calculatedepart(carArray[i]); // 두 지역 사이의 거리를 의미
            carArray[i].distance=calculatelocation(carArray[i])+carArray[i].distance; //차량이 진입 시간부터 이동한 거리를 의미->해가 바뀌면 distance값이 음수가 나오는것을 확인
            if (distance > carArray[i].distance) // 아직 고속도로에 차가 존재하는 경우 //고속도로가 존재하지 않는 경우생각
            {
                carArray[i].location = startend(carArray[i]);
                carArray[i].location=Math.abs(carArray[i].location); //차량의 위치를 절대값으로 나타냄
                if (i > 0 && carArray[i].carnumber == carArray[i - 1].carnumber&&carArray[i].entrance.equals(carArray[i-1].entrance)) 
                {
                    continue; // 같은 차량 번호일 경우 출력 스킵
                }
                System.out.printf("%d. %d %dcc %dkm %s->%s %04d/%02d/%02d-%02d:%02d 위치:%d \n", printnumber++, carArray[i].carnumber,
                carArray[i].carcc, carArray[i].carspeed, carArray[i].start, carArray[i].end,
                carArray[i].entrance.year, carArray[i].entrance.month, carArray[i].entrance.date,
                carArray[i].entrance.hour, carArray[i].entrance.minute, carArray[i].location);
                printinfo=true;
            }
        }
        if(!printinfo) //차량의 정보가 출력되지 않을때
        {
            System.out.println("고속도로에 차량이 존재하지 않습니다.");
        }
    }
    public static void initializeEntrance(Carinfo newCar, time current) // 고속도로 입장시간을 초기화하는 메서드
    {
        newCar.entrance = new time();
        newCar.entrance.year = current.year;
        newCar.entrance.month = current.month;
        newCar.entrance.date = current.date;
        newCar.entrance.hour = current.hour;
        newCar.entrance.minute = current.minute;
    }

    public static int calculatelocation(Carinfo newCar) 
    {
        if (newCar == null || current == null) 
        {
            return 0; // 예외 처리: 차량 정보나 현재 시간이 null인 경우 위치를 0으로 반환하거나 다른 처리 방법 선택
        }
        //해가 바뀌는 경우 예외처리 필요
        int totalgap=calculateTimeGap(current, newCar.halftime);
    
        int velocity = newCar.carspeed; // 시속 속도를 km/h 단위로 사용합니다.
        double timeHours = totalgap / 60.0; // 분을 시간으로 변환합니다.
        double distance = velocity * timeHours; // 시간과 속도를 이용하여 거리를 계산합니다.
        
        int roundedDistance = (int) Math.round(distance); // 반올림한 거리를 계산합니다.
        newCar.halftime.year=current.year; //현재시간으로 변경
        newCar.halftime.month=current.month;
        newCar.halftime.date=current.date;
        newCar.halftime.hour=current.hour;
        newCar.halftime.minute=current.minute; //
        return Math.abs(roundedDistance);
    }
    public static int startend(Carinfo newCar) 
    {
        if (location[1].equals(newCar.start) && !location[0].equals(newCar.end)) 
        { // 수원에서 정방향
            return 30+newCar.distance;
        } else if (location[1].equals(newCar.start) && location[0].equals(newCar.end))
        { // 수원에서 역방향
            return -30+newCar.distance;
        } else if (location[2].equals(newCar.start) && (!location[0].equals(newCar.end) || !location[1].equals(newCar.end))) 
        { // 대전에서 정방향
            return 130+newCar.distance;
        } 
        else if (location[2].equals(newCar.start) && (location[1].equals(newCar.end) || location[0].equals(newCar.end))) 
        { // 대전에서 역방향
            return newCar.distance-130;
        } 
        else if (location[3].equals(newCar.start) && location[4].equals(newCar.end)) 
        { // 대구에서 정방향
            return 290+newCar.distance;
        }
         else if (location[3].equals(newCar.start) && !location[4].equals(newCar.end)) 
         { // 대구에서 역방향
            return newCar.distance-290;
        } else if (location[4].equals(newCar.start)) 
        { // 부산에서 출발
            return newCar.distance-400;
        } else 
        {
            return newCar.distance;
        }
    }
    public static void printdeparture(Carinfo[] Cararray, int carindex) 
{
    boolean printdepart=false;
    int printcar = 1;
    for (int i = 0; i < carindex; i++)
    { 
        // 현재 시간과 도착 시간의 비교
        int departcarTotalMinutes = Cararray[i].departure.year * 365 * 24 * 60 + Cararray[i].departure.month * maxDateInMonth(Cararray[i].departure.year, Cararray[i].departure.month) * 24 * 60
                + Cararray[i].departure.date * 24 * 60 + Cararray[i].departure.hour * 60 + Cararray[i].departure.minute;
        int currentTotalMinutes = current.year * 365 * 24 * 60 + current.month * maxDateInMonth(current.year, current.month) * 24 * 60
                + current.date * 24 * 60 + current.hour * 60 + current.minute;
        int totalgap = currentTotalMinutes - departcarTotalMinutes; //
        
        if (totalgap >= 0)
        {
            departcar[departnumber] = Cararray[i];
            departcar[departnumber].price = calculateprice(Cararray[i]); // 통행료를 계산하는 과정
            departnumber++; //
        }
        else
        {
            continue;
        }
    }
    
    // 도착한 차량들의 정보 출력
    System.out.println("도착한 차량 정보:");
    for (int i = 0; i < departnumber; i++) 
    {
        if (departcar[i] != null) 
        {
            // 이전에 출력한 차량과 동일한 차량 번호를 가진 차량이 있는지 확인
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) 
            {
                if (departcar[j] != null && departcar[i].carnumber == departcar[j].carnumber
                    && departcar[i].entrance.equals(departcar[j].entrance)) // 차량 번호가 같고 입장 시간이 같은 경우만 중복으로 처리
                {
                    isDuplicate = true;
                    break;
                }
            }
            
            // 중복된 차량 번호가 없는 경우에만 출력
            if (!isDuplicate) 
            {
                System.out.printf("%d. %d %dcc %dkm %s->%s %d/%02d/%02d-%02d:%02d %d/%02d/%02d-%02d:%02d %d원\n",
                        printcar++, departcar[i].carnumber, departcar[i].carcc, departcar[i].carspeed,
                        departcar[i].start, departcar[i].end, departcar[i].entrance.year,
                        departcar[i].entrance.month, departcar[i].entrance.date, departcar[i].entrance.hour,
                        departcar[i].entrance.minute, departcar[i].departure.year,
                        departcar[i].departure.month, departcar[i].departure.date, departcar[i].departure.hour,
                        departcar[i].departure.minute, departcar[i].price);
                        printdepart=true;
            }
        } 
    }
    if(!printdepart)
    {
        System.out.println("도착한 차량이 존재하지 않습니다.");
    }
}


    public static int calculateprice(Carinfo newCar) 
    {
    try 
    {
        File file = new File("hcms.txt");
        Scanner scanner = new Scanner(file);
        int normalprice = scanner.nextInt();
        int distanceprice = scanner.nextInt();
        scanner.close();
        int distance = calculatedepart(newCar); // 거리 계산

        int totalprice = (normalprice + distanceprice * distance) * newCar.carspeed / 100 * newCar.carcc / 2000;
        totalprice = totalprice / 10 * 10; // 10으로 나눈 뒤 다시 10을 곱하여 10원 미만을 절삭
        return totalprice;
    } catch (FileNotFoundException e) {
        System.out.println("파일을 찾을 수 없습니다.");
        return -1; // 오류 발생 시 -1을 반환하거나 다른 적절한 값을 반환할 수 있습니다.
    } catch (InputMismatchException e) {
        System.out.println("잘못된 입력이 있습니다.");
        return -1; // 오류 발생 시 -1을 반환하거나 다른 적절한 값을 반환할 수 있습니다.
    }
}

    public static int calculatedepart(Carinfo newCar)
     {
        if(newCar!=null)
        {
            if (location[0].equals(newCar.start) && location[1].equals(newCar.end)) { // 서울에서 수원
                return 30;
            } else if (location[0].equals(newCar.start) && location[2].equals(newCar.end)) { // 서울에서 대전
                return 130;
            } else if (location[0].equals(newCar.start) && location[3].equals(newCar.end)) { // 서울에서 대구
                return 290;
            } else if (location[0].equals(newCar.start) && location[4].equals(newCar.end)) { // 서울에서 부산
                return 400;
            } else if (location[1].equals(newCar.start) && location[0].equals(newCar.end)) { // 수원에서 서울
                return 30;
            } else if (location[1].equals(newCar.start) && location[2].equals(newCar.end)) { // 수원에서 대전
                return 100;
            } else if (location[1].equals(newCar.start) && location[3].equals(newCar.end)) { // 수원에서 대구
                return 260;
            } else if (location[1].equals(newCar.start) && location[4].equals(newCar.end)) { // 수원에서 부산
                return 370;
            } else if (location[2].equals(newCar.start) && location[0].equals(newCar.end)) { // 대전에서 서울
                return 130;
            } else if (location[2].equals(newCar.start) && location[1].equals(newCar.end)) { // 대전에서 수원
                return 100;
            } else if (location[2].equals(newCar.start) && location[3].equals(newCar.end)) { // 대전에서 대구
                return 190;
            } else if (location[2].equals(newCar.start) && location[4].equals(newCar.end)) { // 대전에서 부산
                return 300;
            } else if (location[3].equals(newCar.start) && location[0].equals(newCar.end)) { // 대구에서 서울
                return 290;
            } else if (location[3].equals(newCar.start) && location[1].equals(newCar.end)) { // 대구에서 수원
                return 260;
            } else if (location[3].equals(newCar.start) && location[2].equals(newCar.end)) { // 대구에서 대전
                return 190;
            } else if (location[3].equals(newCar.start) && location[4].equals(newCar.end)) { // 대구에서 부산
                return 110;
            } else if (location[4].equals(newCar.start) && location[0].equals(newCar.end)) { // 부산에서 서울
                return 400;
            } else if (location[4].equals(newCar.start) && location[1].equals(newCar.end)) { // 부산에서 수원
                return 370;
            } else if (location[4].equals(newCar.start) && location[2].equals(newCar.end)) { // 부산에서 대전
                return 300;
            } else if (location[4].equals(newCar.start) && location[3].equals(newCar.end)) { // 부산에서 대구
                return 110;
            } else 
            {
                // 그 외의 경우는 거리가 0입니다.
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }
    public static void endtime(int distance, Carinfo newCar) // 
    {
        //carlocatoin고려해야됨
        int velocity = newCar.carspeed * 1000 / 60; // 속도를 m/분으로 변환
        distance= distance * 1000; // km를 m로 변환
        int gap = distance / velocity; // 속도로 거리를 나누어 도착 예상 시간(분)을 계산
        
        int hoursToAdd = gap / 60; // 시간에 추가할 값
        int minutesToAdd = gap % 60; // 분에 추가할 값
        
        // 예상 도착 시간을 계산하여 업데이트
        newCar.departure.hour =newCar.entrance.hour+hoursToAdd;
        newCar.departure.minute =newCar.entrance.minute+minutesToAdd;
        
        // 시간이 24시를 넘어가는 경우
        if (newCar.departure.hour >= 24) 
        {
            newCar.departure.hour =newCar.departure.hour-24; // 다음 날로 넘어가기 위해 24를 뺌
            // 다음 날이 되었으므로 날짜를 1 증가시킴
            newCar.departure.date=newCar.departure.date+1;
            // 다음 날이 되었는데 현재 월의 마지막 날인 경우
            if (newCar.departure.date > maxDateInMonth(newCar.departure.year, newCar.departure.month)) 
            {
                newCar.departure.date = 1; // 다음 달의 첫 날로 설정
                newCar.departure.month++; // 다음 달로 넘어감
                // 다음 달이 13월이 되는 경우
                if (newCar.departure.month > 12) 
                {
                    newCar.departure.month = 1; // 1월로 설정
                    newCar.departure.year++; // 다음 해로 넘어감
                }
            }
        }
        // 분이 60분을 넘어가는 경우
        if (newCar.departure.minute >= 60) 
        {
            newCar.departure.minute -= 60; // 60분을 빼고
            newCar.departure.hour++; // 시간에 1을 추가
            // 시간이 24시가 되는 경우
            if (newCar.departure.hour >= 24) 
            {
                newCar.departure.hour -= 24; // 다음 날로 넘어가기 위해 24를 뺌
                newCar.departure.date++;
                // 다음 날이 되었는데 현재 월의 마지막 날인 경우
                if (newCar.departure.date > maxDateInMonth(newCar.departure.year, newCar.departure.month)) 
                {
                    newCar.departure.date = 1; // 다음 달의 첫 날로 설정
                    newCar.departure.month++; // 다음 달로 넘어감
                    // 다음 달이 13월이 되는 경우
                    if (newCar.departure.month > 12) 
                    {
                        newCar.departure.month = 1; // 1월로 설정
                        newCar.departure.year++; // 다음 해로 넘어감
                    }
                }
            }
        }
    }
    
    // 주어진 연도와 월에 해당하는 월의 마지막 날짜를 반환하는 메서드
    public static int maxDateInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // 잘못된 입력인 경우
        }
    }
    
    // 윤년 여부를 확인하는 메서드
    public static boolean isLeapYear(int year) 
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void initializehalftime(Carinfo newCar, time current) 
    {
        newCar.halftime = new time();
        newCar.halftime.year = current.year;
        newCar.halftime.month = current.month;
        newCar.halftime.date = current.date;
        newCar.halftime.hour = current.hour;
        newCar.halftime.minute = current.minute;
    }
    public static void initializeDeparture(Carinfo newCar) 
    {
        newCar.departure = new time();
        newCar.departure.year = newCar.entrance.year;
        newCar.departure.month = newCar.entrance.month;
        newCar.departure.date = newCar.entrance.date;
        newCar.departure.hour = newCar.entrance.hour;
        newCar.departure.minute = newCar.entrance.minute;
    }
    
    public static class Carinfo 
    {
        int carnumber; // 차량번호
        String start; // 진입장소
        String end; // 진출장소
        int carcc; // 차 배기량
        int carspeed; // 차 속도
        int location; // 차 위치
        int distance;
        time entrance; // 입장 시간
        time departure; //도착 시간
        time halftime;
        int price; //통행료
    }
}