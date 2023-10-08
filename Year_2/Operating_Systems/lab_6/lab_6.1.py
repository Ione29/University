import csv

class Factor(object):
    def __init__(self, id = "0", name = "undefined", status = "unknown", time = "unspecified"):
        self.id = id
        self.name = name
        self.status = status
        self.time = time
            
    def show(self):
        print("ID: " + self.id + " | Name: " + self.name + " | Status: " + self.status)

class Person(Factor):
    def __init__(self, **kwargs):
        super(Person, self).__init__(**kwargs)
        self.location = location
        self.habit = habit
        
    def move(self):
        print(self.name + " moved!")
        
    def getIn(self):
        print(self.name + " got in!")
        
    def getOut(self):
        print(self.name + " got out!")
        
    def use(self):
        print(self.name + " used...")
        
class Home_Applicance(Factor):
    def __init__(self, **kwargs):
        super(Home_Applicance, self).__init__(**kwargs)
        self.location = location
        self.effectLevel = effectLevel
    
    def setStatus(self, newStatus):
        oldStatus = self.status
        self.status = newStatus
        print("Changed status from " + oldStatus + " to " + self.status + "!")
        
class Environment(Factor):
    def __init__(self, **kwargs):
        super(Environment, self).__init__(**kwargs)
        self.temperature = temperature
        self.humidity = humidity
        self.illumination = illumination
        self.noiseLevel = noiseLevel
        
    def getEnvironmentalInfo(self):
        print(self.name + "\'s environmental info:" +
                "\nTemperature: " + self.temperature + 
                "\nHumidity: " + self.humidity +
                "\nIllumination: " + self.illumination +
                "\nNoise Level: " + self.noiseLevel)
            
class Internal(Environment):
    def __init__(self, **kwargs):
        super(Internal, self).__init__(**kwargs)
        self.size = size
            
    def getEnvironmentFromApplianceEffect(self):
        print(super().getEnvironmentalInfo())
        print("\nSize: " + self.size)
        
class Weather(Environment):
    def __init__(self, **kwargs):
        super(Weather, self).__init__(**kwargs)
        self.level = level

    def setEffect(self, newEffect):
        oldEffect = self.effect
        self.effect = newEffect
        print("Changed effect from " + oldEffect + " to " + self.effect)

class Virtual_Space(object):
    def __init__(self, size = "0", location="unknown", factors = []):
        self.size = size
        self.location = location
        self.factors = factors
        
    def show(self):
        print("About " + self.name + 
              ":\nSize: " + self.size + 
              "\nLocation: " + self.location)
        
        for factor in self.factors:
            print(factor.show() + "\n")    
        
    def getEvent(self):
        return self.event #??????? what is the event
        

class DBConnection(object):
    def __init__(self, **kwargs):
        self.connectionString = connectionString
        
    def read():
        readString = "string that was read"
        return readString
    
    def write():
        print("String was written to databse!")

    def close():
        print("Database closed!")
        
class Reasoning(object):
    def __init__(self, **kwargs):
        self.dbConnection = dbConnection
        self.refSmartHome = redSmartHome
        
    def getCases(self):
        case = "case 1: foobar"
        return case
    
    def doReasoning(self):
        return (True == False)

    def caseMatching(self, caseSearched):
        if caseSearched.equals(case) :
            print("Case found!")
            return True
        else:
            print("Case does not match!")
            return False
        
    def GetEnvirnomentalInfo():
        env = Environment(id = 1, name="indoors", status="safe", temperature=24, humidity=33, illumination=7, noiseLevel = 0)
        print(env.getEnvironmentalInfo())
        
    
class Disease(object):
    def __init__(self, name = "unnamed", factors = []):
        self.name = name
        self.factors = factors

    
