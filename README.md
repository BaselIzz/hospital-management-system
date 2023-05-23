# hospital-management-system


## Erd DIgram 4 core  of hospital-mangment- System 

![Untitled Diagram (2)](https://github.com/BaselIzz/hospital-management-system/assets/102633816/806fb9b7-f9d1-48c9-a91c-fda3cff9c47e)

## Java Spring 
![img](https://github.com/BaselIzz/hospital-management-system/assets/102633816/518fc747-6e0d-46df-af21-67248eca1fb5)

 
 | Http method | URL PATH                        | HTTP status code | Description                                                   | Sample Request                          | Sample Response                                                |
|-------------|---------------------------------|-----------------|---------------------------------------------------------------|-----------------------------------------|---------------------------------------------------------------|
| GET         | http://localhost:9090/specialty | 200             | The following method returns all specialties                  | GET http://localhost:9090/specialty    | "[{ ""id"": 2, ""description"": ""Description1"", ""name"": ""Name1""}]" |
| GET         | http://localhost:9090/specialty/8 | 200             | The following method returns a specialty by ID                | GET http://localhost:9090/specialty/8  | "{ ""id"": 8, ""description"": ""1180336"", ""name"": ""Basel""}" |
| DELETE      | http://localhost:9090/specialty/1 | 200             | The following method deletes a specialty by ID if found       | DELETE http://localhost:9090/specialty/1 | Deleted successfully                                           |
| PUT         | http://localhost:9090/specialty/8 | 200             | The following method updates a specialty and returns the value | PUT http://localhost:9090/specialty/8    | "{ ""id"": 8, ""description"": ""1180336"", ""name"": ""Basel""}" |
| POST        | http://localhost:9090/specialty | 200             | The following method creates a specialty and returns the value | POST http://localhost:9090/specialty   | "{ ""id"": 9, ""description"": ""hello"", ""name"": ""Basel""}" |
| GET         | http://localhost:9090/SpecialtyDoctor | 200             | The following method returns all specialty doctors             | GET http://localhost:9090/SpecialtyDoctor | "[{ ""id"": 6, ""doctor"": 1, ""specialty"": 2}]" |
| GET         | http://localhost:9090/SpecialtyDoctor/7 | 200             | The following method returns a specialty doctor by ID          | GET http://localhost:9090/SpecialtyDoctor/7 | "{ ""id"": 7, ""doctor"": 1, ""specialty"": 4}" |
| DELETE      | http://localhost:9090/SpecialtyDoctor/5 | 200             | The following method deletes a specialty doctor by ID if found | DELETE http://localhost:9090/SpecialtyDoctor/5 | Deleted successfully                                           |
| PUT         | http://localhost:9090/SpecialtyDoctor/7 | 200             | The following method updates a specialty doctor and returns the value | PUT http://localhost:9090/SpecialtyDoctor/7 | "{ ""id"": 7, ""doctor"": 1, ""specialty"": 4}" |
| POST        | http://localhost:9090/SpecialtyDoctor | 200             | The following method creates a specialty doctor and returns the value | POST http://localhost:9090/SpecialtyDoctor | "{ ""id"": 7, ""doctor"": 2, ""specialty"": 3}" |
| GET         | http://localhost:9090/Patient    | 200             | The following method returns all patients                       | GET http://localhost:9090/Patient       | "{ ""id"": 1, ""dob"": ""1990-01-01T00:00:00.000+00:00"", ""name"": ""basel izz"", ""address"": ""123 Main Street"", ""contentnumber"": ""1234567890"", ""note"": ""Some notes"", ""gender"": ""Male"" }" |
| GET         | http://localhost:9090/Patient/3  | 200             | The following method returns a patient by ID                    | GET http://localhost:9090/Patient/3     | "{ ""id"": 3, ""dob"": ""1990-01-01T00:00:00.000+00:00"", ""name"": ""ameera"", ""address"": ""123 Main Street"", ""contentnumber"": ""1234567890"", ""note"": ""Some notes"", ""gender"": ""Female"" }" |
| DELETE      | http://localhost:9090/Patient/10 | 200             | The following method deletes a patient by ID if found           | DELETE http://localhost:9090/Patient/10 | Deleted successfully                                           |
| PUT         | http://localhost:9090/Patient/100 | 200             | The following method updates a patient and returns the value    | PUT http://localhost:9090/Patient/10   | "{ ""id"": 10, ""dob"": ""1990-01-01T00:00:00.000+00:00"", ""name"": ""basel"", ""address"": ""123 Main Street"", ""contentnumber"": ""1234567890"", ""note"": ""1234567890"", ""gender"": ""Male"" }" |
| POST        | http://localhost:9090/Patient    | 200             | The following method creates a patient and returns the value    | POST http://localhost:9090/Patient      | "{ ""id"": 11, ""dob"": ""1990-01-01T00:00:00.000+00:00"", ""name"": ""said"", ""address"": ""123 Main Street"", ""contentnumber"": ""1234567890"", ""note"": ""1234567890"", ""gender"": ""Male"" }" |
| GET         | http://localhost:9090/Doctor     | 200             | The following method returns all doctors                        | GET http://localhost:9090/Doctor        | "{ ""name"": ""Ahamd Mohsen"", ""contentNumber"": ""1234567890"", ""id"": 2 }" |
| GET         | http://localhost:9090/Doctor/1   | 200             | The following method returns a doctor by ID                     | GET http://localhost:9090/Doctor/2      | "{ ""name"": ""Ahamd Mohsen"", ""contentNumber"": ""1234567890"", ""id"": 2 }" |
| DELETE      | http://localhost:9090/Doctor/2   | 200             | The following method deletes a doctor by ID if found            | DELETE http://localhost:9090/Doctor/2   | Deleted successfully                                           |
| PUT         | http://localhost:9090/Doctor/4   | 200             | The following method updates a doctor and returns the value     | PUT http://localhost:9090/Doctor/4      | "{ ""name"": ""Ahamd Suad"", ""contentNumber"": ""1234567890"", ""id"": 4 }" |
| POST        | http://localhost:9090/Doctor     | 200             | The following method creates a doctor and returns the value     | POST http://localhost:9090/Doctor       | "{ ""name"": ""Ahamd Ahmad"", ""contentNumber"": ""1234567890"", ""id"": 5 }" |
| GET         | http://localhost:9090/Appointment | 200             | The following method returns all appointments                   | GEThttp://localhost:9090/Patient        | "[{ ""id"": 3, ""appointmentDate"": ""1990-01-01T00:00:00.000+00:00"", ""doctor"": 1, ""patient"": 1, ""room"": ""BASEL"", ""cost"": 190.5 }]" |
| GET         | http://localhost:9090/Appointment/4 | 200             | The following method returns an appointment by ID               | GET http://localhost:9090/Appointment/4  | "{ ""id"": 4, ""appointmentDate"": ""1990-01-01T00:00:00.000+00:00"", ""doctor"": 1, ""patient"": 2, ""room"": ""Ahmad"", ""cost"": 195.5 }" |
| DELETE      | http://localhost:9090/Appointment/5 | 200             | The following method deletes an appointment by ID if found      | DELETE  http://localhost:9090/Appointment/5 | Deleted successfully                                           |
| PUT         | http://localhost:9090/Appointment/4 | 200             | The following method updates an appointment and returns the value | PUT http://localhost:9090/Doctor/4    | "{ ""id"": 4, ""appointmentDate"": ""1990-01-01T00:00:00.000+00:00"", ""doctor"": 1, ""patient"": 2, ""room"": ""Ahmad"", ""cost"": 195.5 }" |
| POST        | http://localhost:9090/Appointment | 200             | The following method creates an appointment and returns the value | "{ ""appointmentDate"":""1990-01-01T00:00:00.000+00:00"", ""doctor"":1, ""patient"":1, ""room"":""BASEL"", ""cost"":190.5 }" | "{ ""id"": 5, ""appointmentDate"": ""1990-01-01T00:00:00.000+00:00"", ""doctor"": 1, ""patient"": 1, ""room"": ""BASEL"", ""cost"": 190.5 }" |

 
 



THE CODE IN THE Master Branch
