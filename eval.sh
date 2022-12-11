#change me
REPO_LOCATION=https://github.com/revature-curriculum/pep-labs

CURRENT_DIR=$(pwd)
PARENT_DIR=$CURRENT_DIR/labs
EVAL_APP="java -jar $CURRENT_DIR/parse-surefire-report/target/parse-surefire-report-1.0-SNAPSHOT-jar-with-dependencies.jar"
GEN_REPORT="java -jar $CURRENT_DIR/evaluate-labs/target/evaluate-labs-1.0-SNAPSHOT-jar-with-dependencies.jar"
TEMP_FILE=temp.txt
REPORT=report.json

#rm and creat report file
rm $TEMP_FILE
touch $TEMP_FILE
rm $REPORT
touch $REPORT

#get labs from repo
git clone $REPO_LOCATION labs

echo "Begin Evaluating Week: 1"
#Start lab
CURRENT_LAB=$PARENT_DIR/Intro_To_Java/Start
echo $CURRENT_LAB
cd $CURRENT_LAB
mvn test &> $CURRENT_DIR/output.txt
($EVAL_APP $CURRENT_LAB/target/surefire-reports/TEST-GuideTest.xml $CURRENT_DIR/$TEMP_FILE) || true


#hello world lab
CURRENT_LAB=$PARENT_DIR/Intro_To_Java/Hello_World
echo $CURRENT_LAB
cd $CURRENT_LAB
mvn test &> $CURRENT_DIR/output.txt
($EVAL_APP $CURRENT_LAB/target/surefire-reports/TEST-HelloWorldTest.xml $CURRENT_DIR/$TEMP_FILE) || true



($GEN_REPORT $CURRENT_DIR/$TEMP_FILE $CURRENT_DIR/$REPORT) || true

cd $CURRENT_DIR
rm $TEMP_FILE

echo "REPORT CREATED UNDER $CURRENT_DIR/$REPORT"

rm -rf $PARENT_DIR
